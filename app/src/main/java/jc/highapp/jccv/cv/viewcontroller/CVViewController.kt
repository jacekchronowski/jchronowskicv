package jc.highapp.jccv.cv.viewcontroller

import jc.highapp.jccv.architecture.BaseViewController
import jc.highapp.jccv.cv.model.CVState
import jc.highapp.jccv.cv.viewbinding.CVViewBinding
import jc.highapp.jccv.cv.viewmodel.CVViewModel
import jc.highapp.jccv.plugins.LoadingPlugin

class CVViewController : BaseViewController<CVViewBinding, CVState, CVViewModel>() {

    private val loadingPlugin : LoadingPlugin = LoadingPlugin()

    override fun setupView() {
        setupPlugins()
        viewBinding.setupList()

        viewModel.onInit()
    }

    override fun destroyView() = Unit

    override fun render(state: CVState) {
        loadingPlugin.showLoading(state.isLoading)
        viewBinding.setListItems(state.skills)
    }

    private fun setupPlugins() {
        addPlugin(loadingPlugin)
    }
}
