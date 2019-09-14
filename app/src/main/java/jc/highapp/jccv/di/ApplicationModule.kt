package jc.highapp.jccv.di

import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import jc.highapp.jccv.main.MainActivity
import jc.highapp.jccv.navigation.Navigator
import javax.inject.Singleton


@Module
abstract class ApplicationModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @Module
    companion object {
        @JvmStatic
        @Singleton
        @Provides
        fun provideNavigator(): Navigator = Navigator()
    }

}

