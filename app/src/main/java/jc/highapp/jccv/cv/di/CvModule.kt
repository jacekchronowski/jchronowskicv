package jc.highapp.jccv.cv.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import jc.highapp.jccv.cv.view.CVFragment
import jc.highapp.jccv.cv.viewmodel.CVViewModel
import jc.highapp.jccv.di.ViewModelBuilder
import jc.highapp.jccv.di.ViewModelKey

@Module
abstract class CvModule {

    @ContributesAndroidInjector(modules = [
        ViewModelBuilder::class
    ])
    internal abstract fun skillsFragment(): CVFragment

    @Binds
    @IntoMap
    @ViewModelKey(CVViewModel::class)
    internal abstract fun bindViewModel(viewmodel: CVViewModel): ViewModel
}