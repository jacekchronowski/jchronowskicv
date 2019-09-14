package jc.highapp.jccv.services.auth

import jc.highapp.jccv.utils.Settings

class AuthServiceImpl : AuthService {
    override suspend fun getCurrentUserId(): String? {
        return Settings.CURRENT_USER_ID
    }
}