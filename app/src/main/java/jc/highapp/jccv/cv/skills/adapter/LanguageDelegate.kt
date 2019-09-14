package jc.highapp.jccv.cv.skills.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import jc.highapp.jccv.R
import jc.highapp.jccv.cv.skills.model.SkillItem
import jc.highapp.jccv.utils.inflate

class LanguageDelegate : AdapterDelegate<List<SkillItem>>()  {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = ViewHolder(parent)

    override fun isForViewType(items: List<SkillItem>, position: Int): Boolean = items[position] is SkillItem.UserLanguageItem

    override fun onBindViewHolder(
        items: List<SkillItem>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>) {

    }

    internal class ViewHolder(viewGroup: ViewGroup) : RecyclerView.ViewHolder(viewGroup.inflate(R.layout.skill_language_item_layout))
}
