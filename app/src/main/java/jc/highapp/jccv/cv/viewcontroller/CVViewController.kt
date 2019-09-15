package jc.highapp.jccv.cv.viewcontroller

import jc.highapp.jccv.architecture.BaseViewController
import jc.highapp.jccv.cv.model.CVState
import jc.highapp.jccv.cv.viewbinding.CVViewBinding
import jc.highapp.jccv.cv.viewmodel.CVViewModel
import jc.highapp.jccv.plugins.BottomNavigationPlugin
import jc.highapp.jccv.plugins.LoadingPlugin

class CVViewController(
    private val loadingPlugin : LoadingPlugin = LoadingPlugin(),
    private val bottomNavigationPlugin: BottomNavigationPlugin = BottomNavigationPlugin()) : BaseViewController<CVViewBinding, CVState, CVViewModel>() {

    override fun setupView() {
        setupPlugins()
        viewBinding.setupList()
        bottomNavigationPlugin.showBottomNavigationBar(true)

        viewModel.onInit()
    }

    override fun destroyView() = Unit

    override fun render(state: CVState) {
        loadingPlugin.showLoading(state.isLoading)
        viewBinding.setListItems(state.items)
    }

    private fun setupPlugins() {
        addPlugin(loadingPlugin)
    }
}
