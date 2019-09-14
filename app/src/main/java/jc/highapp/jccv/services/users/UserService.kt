package jc.highapp.jccv.services.users

import jc.highapp.jccv.services.model.Language
import jc.highapp.jccv.services.model.Skill
import jc.highapp.jccv.services.model.User
import jc.highapp.jccv.services.model.Tool

interface UserService {

    suspend fun getUserData(userId : String) : User
    suspend fun getUserTools(userId : String) : List<Tool>
    suspend fun getUserLanguages(userId : String) : List<Language>
    suspend fun getUserSkills(userId: String) : List<Skill>
}