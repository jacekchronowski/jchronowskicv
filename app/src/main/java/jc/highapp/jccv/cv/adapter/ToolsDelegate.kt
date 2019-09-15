package jc.highapp.jccv.cv.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import jc.highapp.jccv.cv.model.CVItem

class ToolsDelegate : AdapterDelegate<List<CVItem>>() {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = FlexLayoutViewHolder(parent)
    override fun isForViewType(items: List<CVItem>, position: Int): Boolean = items[position] is CVItem.UserToolItem

    override fun onBindViewHolder(
        items: List<CVItem>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>) {

        holder as FlexLayoutViewHolder
        holder.bind(items[position] as CVItem.UserToolItem)
    }
}