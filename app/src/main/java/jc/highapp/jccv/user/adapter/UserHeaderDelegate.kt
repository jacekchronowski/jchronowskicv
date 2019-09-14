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
import kotlinx.android.synthetic.main.header_layout_item_layout.view.*

class UserHeaderDelegate(private val onItemClick: ((UserAction) -> Unit)?) : AdapterDelegate<List<UserListItem>>() {



    override fun onBindViewHolder(items: List<UserListItem>, position: Int, holder: RecyclerView.ViewHolder, payloads: MutableList<Any>) {
        val item = items[position] as UserListItem.Header
        holder as ViewHolder

        holder.itemView.tv_user_name.text = item.name
        holder.itemView.tv_user_position.text = item.position

        holder.itemView.tv_label1.setText(item.actions[0].userActionNamResId)
        holder.itemView.tv_label2.setText(item.actions[1].userActionNamResId)
        holder.itemView.tv_label3.setText(item.actions[2].userActionNamResId)

        holder.itemView.iv_label1.setImageResource(item.actions[0].userActionDrawableRes)
        holder.itemView.iv_label2.setImageResource(item.actions[1].userActionDrawableRes)
        holder.itemView.iv_label3.setImageResource(item.actions[2].userActionDrawableRes)

        holder.itemView.group1.setAllOnClickListener { onItemClick?.invoke(item.actions[0]) }
        holder.itemView.group2.setAllOnClickListener { onItemClick?.invoke(item.actions[1]) }
        holder.itemView.group3.setAllOnClickListener { onItemClick?.invoke(item.actions[2]) }
    }

    override fun isForViewType(items: List<UserListItem>, position: Int): Boolean = items[position] is UserListItem.Header
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = ViewHolder(parent)

    internal class ViewHolder(viewGroup: ViewGroup) : RecyclerView.ViewHolder(viewGroup.inflate(R.layout.header_layout_item_layout))
}
