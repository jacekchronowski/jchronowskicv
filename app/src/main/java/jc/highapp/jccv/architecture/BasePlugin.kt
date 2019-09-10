package jc.highapp.jccv.architecture

import android.view.View

abstract class BasePlugin {

    private var view : View? = null

    fun attachView(view : View?) {
        this.view = view
    }

    fun detachView() {
        this.view = null
    }
}