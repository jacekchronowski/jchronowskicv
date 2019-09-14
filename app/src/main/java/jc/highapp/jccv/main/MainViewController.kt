package jc.highapp.jccv.main

import jc.highapp.jccv.navigation.Navigator

class MainViewController(private val navigator: Navigator) {

    private var mainViewBinding : MainViewBinding? = null

    fun setupView(mainViewBinding : MainViewBinding?) {
        this.mainViewBinding = mainViewBinding
        this.mainViewBinding?.setupBottomNavigation {
            when(it) {
                0 -> navigator.showUserFragment()
                1 -> navigator.showCVFragment()
                2 -> navigator.showPortfolioFragment()
            }
        }
        navigator.showUserFragment()
    }

    fun detachView() {
        mainViewBinding = null
    }
}