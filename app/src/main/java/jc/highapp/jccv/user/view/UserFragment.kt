package jc.highapp.jccv.user.view

import androidx.fragment.app.viewModels
import jc.highapp.jccv.R
import jc.highapp.jccv.architecture.BaseFragment
import jc.highapp.jccv.user.binding.UserViewBinding
import jc.highapp.jccv.user.viewcontroller.UserViewController
import jc.highapp.jccv.user.viewmodel.UserViewModel
import jc.highapp.jccv.user.model.UserState

class UserFragment : BaseFragment<UserViewBinding, UserState, UserViewController, UserViewModel>() {
    override val viewModel: UserViewModel by viewModels { viewModelFactory }
    override val layoutResId: Int = R.layout.general_fragment_layout
    override val viewController: UserViewController = UserViewController()
    override val viewBinding: UserViewBinding = UserViewBinding()
}