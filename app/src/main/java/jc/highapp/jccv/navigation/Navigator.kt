package jc.highapp.jccv.navigation

import jc.highapp.jccv.cv.main.view.CVFragment
import jc.highapp.jccv.main.MainActivity
import jc.highapp.jccv.portfolio.PortfolioFragment
import jc.highapp.jccv.user.view.UserFragment
import jc.highapp.jccv.utils.replaceFragment
import javax.inject.Inject

class Navigator @Inject constructor(){

    private var activity: MainActivity? = null

    fun bindRoot(activity : MainActivity) {
        this.activity = activity
    }

    fun unbindRoot() {
        this.activity = null
    }

    fun showUserFragment() {
        activity.replaceFragment(UserFragment())
    }

    fun showCVFragment() {
        activity.replaceFragment(CVFragment())
    }

    fun showPortfolioFragment() {
        activity.replaceFragment(PortfolioFragment())
    }


}