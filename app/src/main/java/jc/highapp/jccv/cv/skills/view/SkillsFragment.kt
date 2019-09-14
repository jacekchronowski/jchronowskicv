package jc.highapp.jccv.cv.skills.view

import androidx.fragment.app.viewModels
import jc.highapp.jccv.R
import jc.highapp.jccv.architecture.BaseFragment
import jc.highapp.jccv.cv.skills.model.SkillsState
import jc.highapp.jccv.cv.skills.viewbinding.SkillsViewBinding
import jc.highapp.jccv.cv.skills.viewcontroller.SkillsViewController
import jc.highapp.jccv.cv.skills.viewmodel.SkillsViewModel

class SkillsFragment : BaseFragment<SkillsViewBinding, SkillsState, SkillsViewController, SkillsViewModel>() {
    override val viewModel: SkillsViewModel by viewModels { viewModelFactory }
    override val layoutResId: Int = R.layout.skills_fragment_layout
    override val viewController: SkillsViewController = SkillsViewController()
    override val viewBinding: SkillsViewBinding = SkillsViewBinding()
}