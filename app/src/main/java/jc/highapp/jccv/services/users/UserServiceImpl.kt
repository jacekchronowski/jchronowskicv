package jc.highapp.jccv.services.users

import android.content.Context
import com.google.gson.Gson
import jc.highapp.jccv.services.model.Language
import jc.highapp.jccv.services.model.Skill
import jc.highapp.jccv.services.model.Tool
import jc.highapp.jccv.services.model.User
import jc.highapp.jccv.utils.Settings
import jc.highapp.jccv.utils.loadJsonFileFromAssets
import kotlinx.coroutines.delay

class UserServiceImpl(context : Context, private val gson : Gson) : UserService {
    private val applicationContext = context.applicationContext

    override suspend fun getUserData(userId: String): User {
        delay(1000)
        val json : String = applicationContext.loadJsonFileFromAssets(
            when(userId) {
                Settings.CURRENT_USER_ID -> "currentUser.json"
                else -> throw IllegalStateException()
            })

        return gson.fromJson(json, User::class.java)
    }

    override suspend fun getUserTools(userId: String): List<Tool> {
        return listOf()
    }

    override suspend fun getUserLanguages(userId: String): List<Language> {
        return listOf()
    }

    override suspend fun getUserSkills(userId: String): List<Skill> {
        return listOf()
    }

}