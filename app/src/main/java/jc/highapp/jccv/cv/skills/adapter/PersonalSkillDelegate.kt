package jc.highapp.jccv.cv.skills.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import jc.highapp.jccv.cv.skills.model.SkillItem

class PersonalSkillDelegate : AdapterDelegate<List<SkillItem>>() {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = EllipsizeTextViewHolder(parent)
    override fun isForViewType(items: List<SkillItem>, position: Int): Boolean = items[position] is SkillItem.UserPersonalSkill

    override fun onBindViewHolder(
        items: List<SkillItem>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>) {

        holder as EllipsizeTextViewHolder
        holder.bind(items[position] as SkillItem.UserPersonalSkill)
    }
}