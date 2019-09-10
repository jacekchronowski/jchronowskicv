package jc.highapp.jccv.architecture

import android.view.View

abstract class BaseViewController<S : BaseState, VM : BaseViewModel<S>> {

    abstract fun detachView()
    abstract fun setupView()
    abstract fun render(state : S)

    fun attachViewModel(viewModel: VM) {

    }

    fun attachView(view: View) {

    }

    fun detachViewModel() {

    }


}