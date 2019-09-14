package jc.highapp.jccv.main

import android.app.Activity

interface MainViewBinding {
    var _view : Activity?

    fun setupBottomNavigation(onBottomItemClick : ((Int)->Unit)?)
}

fun MainViewBinding.attachView(view: Activity?) {
    this._view = view
}

fun MainViewBinding.detachView() {
    _view = null
}

val MainViewBinding.view : Activity
    get() = this._view ?: throw IllegalStateException()