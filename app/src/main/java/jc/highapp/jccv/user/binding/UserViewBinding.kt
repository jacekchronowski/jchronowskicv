package jc.highapp.jccv.user.binding

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jc.highapp.jccv.architecture.BaseViewBinding
import jc.highapp.jccv.user.adapter.UserListItemAdapter
import jc.highapp.jccv.user.model.UserAction
import jc.highapp.jccv.user.model.UserListItem
import kotlinx.android.synthetic.main.general_fragment_layout.view.*

class UserViewBinding : BaseViewBinding() {

    fun setItemsList(items: List<UserListItem>) {
        val adapter = view.rv_user_item_list.adapter as UserListItemAdapter
        adapter.items = items
        adapter.notifyDataSetChanged()
    }

    fun setupList(onItemClick: ((UserAction) -> Unit)?) {

        view.rv_user_item_list.layoutManager = LinearLayoutManager(view.context).apply { orientation = RecyclerView.VERTICAL }
        view.rv_user_item_list.adapter = UserListItemAdapter(onItemClick)
    }
}