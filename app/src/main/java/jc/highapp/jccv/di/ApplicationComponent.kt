package jc.highapp.jccv.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import jc.highapp.jccv.cv.di.CvModule
import jc.highapp.jccv.main.JcCvApplication
import jc.highapp.jccv.portfolio.PorfolioModule
import jc.highapp.jccv.services.di.ServiceModule
import jc.highapp.jccv.user.di.UserModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        AndroidSupportInjectionModule::class,
        UserModule::class,
        ServiceModule::class,
        CvModule::class,
        PorfolioModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<JcCvApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }
}