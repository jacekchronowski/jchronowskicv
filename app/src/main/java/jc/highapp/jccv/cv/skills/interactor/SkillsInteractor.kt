package jc.highapp.jccv.cv.skills.interactor

import jc.highapp.jccv.cv.skills.model.SkillItem
import jc.highapp.jccv.services.auth.AuthService
import jc.highapp.jccv.services.users.UserService
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class SkillsInteractor @Inject constructor(
    private val authService: AuthService,
    private val userService: UserService) {

    suspend fun execute() : List<SkillItem>{
        return coroutineScope {

            val currentUserID = authService.getCurrentUserId()
                ?: throw IllegalStateException("User cannot be null at this point!")
            val tools = async { userService.getUserTools(currentUserID) }
            val languages = async { userService.getUserLanguages(currentUserID) }
            val skills = async { userService.getUserPersonalSkills(currentUserID) }

            mutableListOf<SkillItem>().apply {
                addAll(tools.await().map { SkillItem.UserToolItem(it.toolName) })
                addAll(languages.await().map { SkillItem.UserLanguageItem(it.languageName, it.languageLevel) })
                addAll(skills.await().map { SkillItem.UserPersonalSkill(it.skillName)})
            }
        }
    }
}