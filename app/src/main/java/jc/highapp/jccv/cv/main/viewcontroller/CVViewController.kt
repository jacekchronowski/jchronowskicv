package jc.highapp.jccv.cv.main.viewcontroller

import jc.highapp.jccv.architecture.BaseViewController
import jc.highapp.jccv.cv.main.model.CVState
import jc.highapp.jccv.cv.main.viewbinding.CVViewBinding
import jc.highapp.jccv.cv.main.viewmodel.CVViewModel
import jc.highapp.jccv.plugins.BottomNavigationPlugin

class CVViewController : BaseViewController<CVViewBinding, CVState, CVViewModel>() {

    private val bottomNavigationPlugin = BottomNavigationPlugin()

    override fun setupView() {
        setupPlugins()

        bottomNavigationPlugin.showBottomNavigationBar(true)
        viewBinding.setupTabs()

        viewModel.onInit()
    }

    override fun destroyView() = Unit
    override fun render(state: CVState) = Unit

    private fun setupPlugins() {
        addPlugin(bottomNavigationPlugin)
    }
}