package jc.highapp.jccv.cv.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import jc.highapp.jccv.R
import jc.highapp.jccv.cv.model.CVItem
import jc.highapp.jccv.utils.inflate
import kotlinx.android.synthetic.main.skill_language_item_layout.view.*

class LanguageDelegate : AdapterDelegate<List<CVItem>>()  {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = ViewHolder(parent)

    override fun isForViewType(items: List<CVItem>, position: Int): Boolean = items[position] is CVItem.UserLanguageItem

    override fun onBindViewHolder(
        items: List<CVItem>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>) {

        val item = items[position] as CVItem.UserLanguageItem
        holder.itemView.tv_name.text = "${item.languageName} - ${item.level}"
    }

    internal class ViewHolder(viewGroup: ViewGroup) : RecyclerView.ViewHolder(viewGroup.inflate(R.layout.skill_language_item_layout))
}
