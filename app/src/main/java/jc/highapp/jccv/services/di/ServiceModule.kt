package jc.highapp.jccv.services.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import jc.highapp.jccv.services.auth.AuthService
import jc.highapp.jccv.services.auth.AuthServiceImpl
import jc.highapp.jccv.services.users.UserService
import jc.highapp.jccv.services.users.UserServiceImpl
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    fun provideUserService(context : Context, gson : Gson) : UserService {
        return UserServiceImpl(context, gson)
    }

    @Provides
    fun provideAuthService() : AuthService {
        return AuthServiceImpl()
    }

    @Singleton
    @Provides
    fun provideGson() : Gson {
        return GsonBuilder().create()
    }
}