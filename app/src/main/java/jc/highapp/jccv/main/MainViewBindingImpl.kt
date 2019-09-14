package jc.highapp.jccv.main

import android.app.Activity
import jc.highapp.jccv.R
import jc.highapp.jccv.utils.selectItem
import kotlinx.android.synthetic.main.activity_main.*

class MainViewBindingImpl : MainViewBinding {

    override var _view: Activity? = null

    override fun setupBottomNavigation(onBottomItemClick: ((Int) -> Unit)?) {
        view.bn_view.setOnNavigationItemSelectedListener {
            view.bn_view.selectItem(it.itemId)
            onBottomItemClick?.invoke(mapMenuIdToPostion(it.itemId))
            false
        }
    }

    private fun mapMenuIdToPostion(position : Int) : Int {
        return when(position) {
            R.id.bn_general -> 0
            R.id.bn_cv -> 1
            R.id.bn_portfolio -> 2
            else -> -1
        }
    }
}
