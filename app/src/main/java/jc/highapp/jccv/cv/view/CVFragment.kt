package jc.highapp.jccv.cv.view

import androidx.fragment.app.viewModels
import jc.highapp.jccv.R
import jc.highapp.jccv.architecture.BaseFragment
import jc.highapp.jccv.cv.model.CVState
import jc.highapp.jccv.cv.viewbinding.CVViewBinding
import jc.highapp.jccv.cv.viewcontroller.CVViewController
import jc.highapp.jccv.cv.viewmodel.CVViewModel

class CVFragment : BaseFragment<CVViewBinding, CVState, CVViewController, CVViewModel>() {
    override val viewModel: CVViewModel by viewModels { viewModelFactory }
    override val layoutResId: Int = R.layout.skills_fragment_layout
    override val viewController: CVViewController = CVViewController()
    override val viewBinding: CVViewBinding = CVViewBinding()
}