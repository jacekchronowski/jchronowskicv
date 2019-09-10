package jc.highapp.jccv.general

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import jc.highapp.jccv.di.ViewModelBuilder
import jc.highapp.jccv.di.ViewModelKey

@Module
abstract class GeneralModule {

    @ContributesAndroidInjector(modules = [
        ViewModelBuilder::class
    ])
    internal abstract fun generalFragment(): GeneralFragment

    @Binds
    @IntoMap
    @ViewModelKey(GeneralViewModel::class)
    internal abstract fun bindViewModel(viewmodel: GeneralViewModel): ViewModel
}