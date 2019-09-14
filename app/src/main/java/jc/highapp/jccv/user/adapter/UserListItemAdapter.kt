package jc.highapp.jccv.user.adapter

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import jc.highapp.jccv.user.model.UserAction
import jc.highapp.jccv.user.model.UserListItem

class UserListItemAdapter(onItemClick: ((UserAction) -> Unit)?) : ListDelegationAdapter<List<UserListItem>>() {

    init {

        delegatesManager.addDelegate(UserHeaderDelegate(onItemClick))
        delegatesManager.addDelegate(UserDescriptionDelegate())
        delegatesManager.addDelegate(DividerDelegate())
        delegatesManager.addDelegate(SmallDividerDelegate())
        delegatesManager.addDelegate(MinorItemDelegate(onItemClick))

    }
}