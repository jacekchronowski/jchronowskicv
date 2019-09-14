package jc.highapp.jccv.cv.skills.viewbinding

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jc.highapp.jccv.architecture.BaseViewBinding
import jc.highapp.jccv.cv.skills.adapter.SkillsAdapter
import jc.highapp.jccv.cv.skills.model.SkillItem
import kotlinx.android.synthetic.main.skills_fragment_layout.view.*

class SkillsViewBinding : BaseViewBinding() {
    fun setupList() {
        view.rv_skills_list.adapter = SkillsAdapter()
        view.rv_skills_list.layoutManager = LinearLayoutManager(view.context).apply {
            orientation = RecyclerView.VERTICAL
        }
    }

    fun setListItems(skills: List<SkillItem>) {
        val adapter = view.rv_skills_list.adapter as SkillsAdapter
        adapter.items = skills
        adapter.notifyDataSetChanged()
    }


}