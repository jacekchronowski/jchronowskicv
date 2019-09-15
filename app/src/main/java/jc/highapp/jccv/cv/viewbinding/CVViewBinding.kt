package jc.highapp.jccv.cv.viewbinding

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jc.highapp.jccv.architecture.BaseViewBinding
import jc.highapp.jccv.cv.adapter.CVAdapter
import jc.highapp.jccv.cv.model.CVItem
import kotlinx.android.synthetic.main.skills_fragment_layout.view.*

class CVViewBinding : BaseViewBinding() {
    fun setupList() {
        view.rv_skills_list.adapter = CVAdapter()
        view.rv_skills_list.layoutManager = LinearLayoutManager(view.context).apply {
            orientation = RecyclerView.VERTICAL
        }
    }

    fun setListItems(skills: List<CVItem>) {
        val adapter = view.rv_skills_list.adapter as CVAdapter
        adapter.items = skills
        adapter.notifyDataSetChanged()
    }


}