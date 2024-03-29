package jc.highapp.jccv.architecture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import dagger.android.support.DaggerFragment
import jc.highapp.jccv.di.ViewModelFactory
import javax.inject.Inject

abstract class BaseFragment<VB : BaseViewBinding, S : BaseState, VC : BaseViewController<VB, S, VW>, VW : BaseViewModel<S>> : DaggerFragment(){

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    abstract val viewModel  : VW
    abstract val layoutResId : Int
    abstract val viewController : VC
    abstract val viewBinding : VB

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutResId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewController.attachView(view)
        viewController.attachViewBinding(viewBinding)
        viewController.attachViewModel(viewModel)
        viewController.setupView()

        viewModel.state.observe(this, Observer {
            viewController.render(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.state.removeObservers(this)
        viewModel.onDestroy()
        viewController.detachView()
        viewController.detachViewModel()
        viewController.detachViewBinding()
    }

}