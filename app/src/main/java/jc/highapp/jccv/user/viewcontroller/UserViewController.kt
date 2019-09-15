package jc.highapp.jccv.user.viewcontroller

import jc.highapp.jccv.architecture.BaseViewController
import jc.highapp.jccv.plugins.BottomNavigationPlugin
import jc.highapp.jccv.plugins.LoadingPlugin
import jc.highapp.jccv.user.binding.UserViewBinding
import jc.highapp.jccv.user.model.UserState
import jc.highapp.jccv.user.viewmodel.UserViewModel

class UserViewController(
    private val loadingPlugin: LoadingPlugin = LoadingPlugin(),
    private val bottomNavigationPlugin : BottomNavigationPlugin = BottomNavigationPlugin()) : BaseViewController<UserViewBinding, UserState, UserViewModel>() {

    override fun setupView() {
        setupPlugins()

        bottomNavigationPlugin.showBottomNavigationBar(true)
        viewBinding.setupList { viewModel.onItemClick(it) }

        viewModel.onInit()
    }

    override fun destroyView() = Unit

    override fun render(state: UserState) {
        loadingPlugin.showLoading(state.isLoading)
        viewBinding.setItemsList(state.items)
    }

    private fun setupPlugins() {
        addPlugin(loadingPlugin)
        addPlugin(bottomNavigationPlugin)
    }
}