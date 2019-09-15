package jc.highapp.jccv.services.users

import jc.highapp.jccv.services.model.*

interface UserService {

    suspend fun getUserData(userId : String) : User
    suspend fun getUserTools(userId : String) : List<Tool>
    suspend fun getUserLanguages(userId : String) : List<Language>
    suspend fun getUserProgrammingLanguages(userId : String) : List<ProgrammingLanguage>
    suspend fun getUserPersonalSkills(userId: String) : List<PersonalSkill>
    suspend fun getUserExperience(userId: String) : List<Experience>
}