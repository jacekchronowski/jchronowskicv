package jc.highapp.jccv.user.model

import jc.highapp.jccv.architecture.BaseState

data class UserState(
    val isLoading : Boolean = false,
    val items : List<UserListItem> = listOf()) : BaseState