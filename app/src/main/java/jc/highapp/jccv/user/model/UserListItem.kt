package jc.highapp.jccv.user.model

sealed class UserListItem {

    data class Header(
        val name : String,
        val position : String,
        val imageUrl : String?,
        val actions : List<UserAction>) : UserListItem()
    data class Description(val description : String) : UserListItem()
    data class MinorItem(val userAction: UserAction) : UserListItem()
    object Divider : UserListItem()
    object SmallDivider : UserListItem()
}