package jc.highapp.jccv.cv.skills.viewcontroller

import jc.highapp.jccv.architecture.BaseViewController
import jc.highapp.jccv.cv.skills.model.SkillsState
import jc.highapp.jccv.cv.skills.viewbinding.SkillsViewBinding
import jc.highapp.jccv.cv.skills.viewmodel.SkillsViewModel
import jc.highapp.jccv.plugins.LoadingPlugin

class SkillsViewController : BaseViewController<SkillsViewBinding, SkillsState, SkillsViewModel>() {

    private val loadingPlugin : LoadingPlugin = LoadingPlugin()

    override fun setupView() {
        setupPlugins()
        viewBinding.setupList()

        viewModel.onInit()
    }

    override fun destroyView() = Unit

    override fun render(state: SkillsState) {
        loadingPlugin.showLoading(state.isLoading)
        viewBinding.setListItems(state.skills)
    }

    private fun setupPlugins() {
        addPlugin(loadingPlugin)
    }
}
