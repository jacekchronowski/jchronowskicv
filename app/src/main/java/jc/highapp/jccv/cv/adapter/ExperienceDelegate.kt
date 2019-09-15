package jc.highapp.jccv.cv.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import jc.highapp.jccv.R
import jc.highapp.jccv.cv.model.CVItem
import jc.highapp.jccv.utils.inflate
import kotlinx.android.synthetic.main.experience_item_layout.view.*

class ExperienceDelegate : AdapterDelegate<List<CVItem>>() {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = ViewHolder(parent)
    override fun isForViewType(items: List<CVItem>, position: Int): Boolean = items[position] is CVItem.UserExperienceItem
    override fun onBindViewHolder(
        items: List<CVItem>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>) {


        val item = items[position] as CVItem.UserExperienceItem
        holder.itemView.tv_name.text = "${item.companyName} : ${item.timeline}"
    }

    internal class ViewHolder(viewGroup: ViewGroup) : RecyclerView.ViewHolder(viewGroup.inflate(R.layout.experience_item_layout))
}