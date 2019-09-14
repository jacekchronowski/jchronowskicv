package jc.highapp.jccv.user.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import jc.highapp.jccv.di.ViewModelBuilder
import jc.highapp.jccv.di.ViewModelKey
import jc.highapp.jccv.services.di.ServiceModule
import jc.highapp.jccv.services.users.UserService
import jc.highapp.jccv.user.view.UserFragment
import jc.highapp.jccv.user.viewmodel.UserViewModel
import jc.highapp.jccv.user.interactor.UserInteractor

@Module
abstract class UserModule {

    @ContributesAndroidInjector(modules = [
        ViewModelBuilder::class
    ])
    internal abstract fun userFragment(): UserFragment

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    internal abstract fun bindViewModel(viewmodel: UserViewModel): ViewModel

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun providesA(userService: UserService): UserInteractor = UserInteractor(userService)
    }
}