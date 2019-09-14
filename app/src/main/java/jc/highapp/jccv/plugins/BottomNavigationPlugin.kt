package jc.highapp.jccv.plugins

import jc.highapp.jccv.architecture.BasePlugin
import jc.highapp.jccv.main.MainActivity
import jc.highapp.jccv.utils.visible
import kotlinx.android.synthetic.main.activity_main.*

class BottomNavigationPlugin : BasePlugin() {

    fun showBottomNavigationBar(show : Boolean) {

        val activity = view.context as MainActivity
        activity.bn_view.visible(show)
    }
}