package jc.highapp.jccv.portfolio

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jc.highapp.jccv.di.ViewModelBuilder
import jc.highapp.jccv.user.view.UserFragment

@Module
abstract class PorfolioModule {

    @ContributesAndroidInjector(
        modules = [
            ViewModelBuilder::class
        ]
    )
    internal abstract fun portfolioFragment(): PortfolioFragment
}