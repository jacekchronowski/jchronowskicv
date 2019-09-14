package jc.highapp.jccv.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import jc.highapp.jccv.cv.education.di.EducationModule
import jc.highapp.jccv.cv.experience.di.ExperienceModule
import jc.highapp.jccv.cv.main.di.CVModule
import jc.highapp.jccv.cv.skills.di.SkillsModule
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
        CVModule::class,
        SkillsModule::class,
        ExperienceModule::class,
        EducationModule::class,
        PorfolioModule::class
    ])
interface ApplicationComponent : AndroidInjector<JcCvApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }
}