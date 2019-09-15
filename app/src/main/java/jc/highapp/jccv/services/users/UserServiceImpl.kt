package jc.highapp.jccv.services.users

import android.content.Context
import com.google.gson.Gson
import jc.highapp.jccv.utils.Settings
import jc.highapp.jccv.utils.loadJsonFileFromAssets
import kotlinx.coroutines.delay
import com.google.gson.reflect.TypeToken
import jc.highapp.jccv.services.model.*


class UserServiceImpl(context: Context, private val gson: Gson) : UserService {

    private val applicationContext = context.applicationContext

    override suspend fun getUserData(userId: String): User {
        delay(1000)
        val json: String = applicationContext.loadJsonFileFromAssets(
            when (userId) {
                Settings.CURRENT_USER_ID -> "currentUser.json"
                else -> throw IllegalStateException()
            }
        )

        return gson.fromJson(json, User::class.java)
    }

    override suspend fun getUserTools(userId: String): List<Tool> {
        delay(1000)
        val json: String = applicationContext.loadJsonFileFromAssets(
            when (userId) {
                Settings.CURRENT_USER_ID -> "currentUserTools.json"
                else -> throw IllegalStateException()
            }
        )

        return gson.fromJson(json, object : TypeToken<List<Tool>>() {}.type)
    }

    override suspend fun getUserLanguages(userId: String): List<Language> {
        delay(1000)
        val json: String = applicationContext.loadJsonFileFromAssets(
            when (userId) {
                Settings.CURRENT_USER_ID -> "currentUserLanguages.json"
                else -> throw IllegalStateException()
            }
        )

        return gson.fromJson(json, object : TypeToken<List<Language>>() {}.type)
    }

    override suspend fun getUserPersonalSkills(userId: String): List<PersonalSkill> {
        delay(1000)
        val json: String = applicationContext.loadJsonFileFromAssets(
            when (userId) {
                Settings.CURRENT_USER_ID -> "currentUserSkills.json"
                else -> throw IllegalStateException()
            }
        )

        return gson.fromJson(json, object : TypeToken<List<PersonalSkill>>() {}.type)
    }

    override suspend fun getUserProgrammingLanguages(userId: String): List<ProgrammingLanguage> {
        delay(1000)
        val json: String = applicationContext.loadJsonFileFromAssets(
            when (userId) {
                Settings.CURRENT_USER_ID -> "currentUserProgrammingLanguages.json"
                else -> throw IllegalStateException()
            }
        )

        return gson.fromJson(json, object : TypeToken<List<ProgrammingLanguage>>() {}.type)
    }

    override suspend fun getUserExperience(userId: String): List<Experience> {
        delay(1000)
        val json: String = applicationContext.loadJsonFileFromAssets(
            when (userId) {
                Settings.CURRENT_USER_ID -> "currentUserExperience.json"
                else -> throw IllegalStateException()
            }
        )

        return gson.fromJson(json, object : TypeToken<List<Experience>>() {}.type)    }
}