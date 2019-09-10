package jc.highapp.jccv.general

import androidx.fragment.app.viewModels
import jc.highapp.jccv.R
import jc.highapp.jccv.architecture.BaseFragment

class GeneralFragment : BaseFragment<GeneralState, GeneralViewController, GeneralViewModel>() {
    override val viewModel: GeneralViewModel by viewModels { viewModelFactory }
    override val layoutResId: Int = R.layout.general_fragment_layout
    override val viewController: GeneralViewController = GeneralViewController()
}