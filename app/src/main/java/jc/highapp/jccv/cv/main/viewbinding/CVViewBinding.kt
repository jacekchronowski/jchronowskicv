package jc.highapp.jccv.cv.main.viewbinding

import jc.highapp.jccv.architecture.BaseViewBinding
import jc.highapp.jccv.cv.main.adapter.CvFragmentAdapter
import jc.highapp.jccv.main.MainActivity
import kotlinx.android.synthetic.main.cv_fragment_layout.view.*

class CVViewBinding : BaseViewBinding() {

    fun setupTabs() {
        val activity = view.context as MainActivity
        val fragmentManager = activity.supportFragmentManager

        view.vp_cv_pages.adapter = CvFragmentAdapter(activity.resources, fragmentManager)
        view.tl_tabs.setupWithViewPager(view.vp_cv_pages)
    }
}