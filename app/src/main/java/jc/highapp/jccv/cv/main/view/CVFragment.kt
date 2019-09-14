package jc.highapp.jccv.cv.main.view

import androidx.fragment.app.viewModels
import jc.highapp.jccv.R
import jc.highapp.jccv.architecture.BaseFragment
import jc.highapp.jccv.cv.main.model.CVState
import jc.highapp.jccv.cv.main.viewbinding.CVViewBinding
import jc.highapp.jccv.cv.main.viewcontroller.CVViewController
import jc.highapp.jccv.cv.main.viewmodel.CVViewModel

class CVFragment : BaseFragment<CVViewBinding,CVState,CVViewController, CVViewModel>() {
    override val viewModel: CVViewModel by viewModels { viewModelFactory  }
    override val layoutResId: Int = R.layout.cv_fragment_layout
    override val viewController: CVViewController = CVViewController()
    override val viewBinding: CVViewBinding = CVViewBinding()
}
