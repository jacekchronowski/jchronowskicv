package jc.highapp.jccv.services.users

import jc.highapp.jccv.services.model.LanguageApi
import jc.highapp.jccv.services.model.SkillApi
import jc.highapp.jccv.services.model.UserApi
import jc.highapp.jccv.services.model.ToolApi

interface UserService {

    suspend fun getUserData(userId : String) : UserApi
    suspend fun getUserTools(userId : String) : List<ToolApi>
    suspend fun getUserLanguages(userId : String) : List<LanguageApi>
    suspend fun getUserSkills(userId: String) : List<SkillApi>
}