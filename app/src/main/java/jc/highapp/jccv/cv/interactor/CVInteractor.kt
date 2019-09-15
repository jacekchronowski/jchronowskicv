package jc.highapp.jccv.cv.interactor

import jc.highapp.jccv.cv.model.CVItem
import jc.highapp.jccv.services.auth.AuthService
import jc.highapp.jccv.services.model.Experience
import jc.highapp.jccv.services.users.UserService
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class CVInteractor @Inject constructor(
    private val authService: AuthService,
    private val userService: UserService) {

    suspend fun execute() : List<CVItem>{
        return coroutineScope {

            val currentUserID = authService.getCurrentUserId()
                ?: throw IllegalStateException("User cannot be null at this point!")
            val tools = async { userService.getUserTools(currentUserID) }
            val languages = async { userService.getUserLanguages(currentUserID) }
            val skills = async { userService.getUserPersonalSkills(currentUserID) }
            val programmingLanguages = async { userService.getUserProgrammingLanguages(currentUserID)}
            val experience = async { userService.getUserExperience(currentUserID) }

            mutableListOf<CVItem>().apply {
                addAll(experience.await().map { CVItem.UserExperienceItem(
                    "${it.experienceStart} - ${it.experienceEnd ?: ""}",
                    it.companyName,
                    it.companyImageUrl) })
                addAll(programmingLanguages.await().map { CVItem.UserProgrammingLanguageItem(it.languageName, it.languageLevel) })

                tools.await()
                    .map { it.toolName }
                    .takeIf { it.isNotEmpty() }
                    ?.let {
                        add( CVItem.UserToolItem(it))
                    }

                addAll(languages.await().map { CVItem.UserLanguageItem(it.languageName, it.languageLevel) })

                skills.await()
                    .map { it.skillName }
                    .takeIf { it.isNotEmpty() }
                    ?.let {
                        add(CVItem.UserPersonalSkill(it))
                    }


            }
        }
    }
}