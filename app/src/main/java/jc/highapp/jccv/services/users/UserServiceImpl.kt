package jc.highapp.jccv.services.users

import jc.highapp.jccv.services.model.LanguageApi
import jc.highapp.jccv.services.model.SkillApi
import jc.highapp.jccv.services.model.ToolApi
import jc.highapp.jccv.services.model.UserApi

class UserServiceImpl : UserService {
    override suspend fun getUserData(userId: String): UserApi {
        return UserApi()
    }

    override suspend fun getUserTools(userId: String): List<ToolApi> {
        return listOf()
    }

    override suspend fun getUserLanguages(userId: String): List<LanguageApi> {
        return listOf()
    }

    override suspend fun getUserSkills(userId: String): List<SkillApi> {
        return listOf()
    }

}