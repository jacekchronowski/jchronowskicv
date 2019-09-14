package jc.highapp.jccv.architecture

import android.view.View
import java.lang.IllegalStateException

abstract class BasePlugin {

    private var _view : View? = null
    protected val view : View
        get() = _view ?: throw IllegalStateException()

    fun attachView(view : View?) {
        this._view = view
    }

    fun detachView() {
        this._view = null
    }
}