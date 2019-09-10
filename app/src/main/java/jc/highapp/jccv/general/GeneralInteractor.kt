package jc.highapp.jccv.general

import jc.highapp.jccv.services.users.UserService
import javax.inject.Inject

class GeneralInteractor @Inject constructor(private val userService : UserService) {

    suspend fun execute(userId : String) : GeneralData {
        return GeneralData()
    }
}