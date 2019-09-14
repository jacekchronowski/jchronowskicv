package jc.highapp.jccv.cv.experience.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import jc.highapp.jccv.cv.experience.view.ExperienceFragment
import jc.highapp.jccv.cv.main.view.CVFragment
import jc.highapp.jccv.cv.main.viewmodel.CVViewModel
import jc.highapp.jccv.cv.skills.view.SkillsFragment
import jc.highapp.jccv.di.ViewModelBuilder
import jc.highapp.jccv.di.ViewModelKey
import jc.highapp.jccv.services.di.ServiceModule
import jc.highapp.jccv.services.users.UserService
import jc.highapp.jccv.user.view.UserFragment
import jc.highapp.jccv.user.viewmodel.UserViewModel
import jc.highapp.jccv.user.interactor.UserInteractor

@Module
abstract class ExperienceModule {

    @ContributesAndroidInjector(modules = [
        ViewModelBuilder::class
    ])
    internal abstract fun experienceFragment(): ExperienceFragment

}