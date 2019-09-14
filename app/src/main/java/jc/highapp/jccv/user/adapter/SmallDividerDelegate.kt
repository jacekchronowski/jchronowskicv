package jc.highapp.jccv.user.adapter

import android.view.ViewGroup
import androidx.constraintlayout.widget.Group
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import jc.highapp.jccv.R
import jc.highapp.jccv.user.model.UserAction
import jc.highapp.jccv.user.model.UserListItem
import jc.highapp.jccv.utils.inflate
import jc.highapp.jccv.utils.setAllOnClickListener
import kotlinx.android.synthetic.main.description_item_layout.view.*
import kotlinx.android.synthetic.main.header_layout_item_layout.view.*

class SmallDividerDelegate : AdapterDelegate<List<UserListItem>>() {

    override fun onBindViewHolder(items: List<UserListItem>, position: Int, holder: RecyclerView.ViewHolder, payloads: MutableList<Any>) = Unit

    override fun isForViewType(items: List<UserListItem>, position: Int): Boolean = items[position] is UserListItem.SmallDivider
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = ViewHolder(parent)

    internal class ViewHolder(viewGroup: ViewGroup) : RecyclerView.ViewHolder(viewGroup.inflate(R.layout.small_divider_item_layout))
}
