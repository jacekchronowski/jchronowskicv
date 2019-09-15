package jc.highapp.jccv.architecture

import android.view.View

abstract class BaseViewController<VB : BaseViewBinding, S : BaseState, VM : BaseViewModel<S>> {

    abstract fun setupView()
    abstract fun destroyView()
    abstract fun render(state : S)

    private var _view : View? = null
    private var _viewModel : VM? = null
    private var _viewBinding : VB? = null

    protected val viewModel : VM
        get() = _viewModel ?: throw IllegalStateException()

    protected val viewBinding : VB
        get() = _viewBinding ?: throw IllegalStateException()

    val plugins : MutableList<BasePlugin> = mutableListOf()

    fun attachViewModel(viewModel: VM) {
        _viewModel = viewModel
    }

    fun attachView(view: View) {
        _view = view
    }

    fun detachView() {
        plugins.forEach { it.detachView() }
        _view = null
    }

    fun detachViewModel() {
        _viewModel = null
    }

    fun attachViewBinding(viewBinding: VB) {
        viewBinding.attachView(_view)
        _viewBinding = viewBinding
    }

    fun detachViewBinding() {
        _viewBinding?.detachView()
        _viewBinding = null
    }

    fun addPlugin(plugin : BasePlugin) {
        plugin.attachView(_view)
        plugins.add(plugin)
    }



}