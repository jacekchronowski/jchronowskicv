package jc.highapp.jccv.services.auth

interface AuthService  {
    suspend fun getCurrentUserId() : String?
}