package jc.highapp.jccv.architecture

import android.view.View

abstract class BaseViewBinding {

    var _view : View? = null
    val view : View
        get() = this._view ?: throw IllegalStateException()

    fun attachView(view: View?) {
        this._view = view
    }

    fun detachView() {
        _view = null
    }
}


