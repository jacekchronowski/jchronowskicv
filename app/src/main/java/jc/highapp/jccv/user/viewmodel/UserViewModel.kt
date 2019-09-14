package jc.highapp.jccv.user.viewmodel

import jc.highapp.jccv.architecture.BaseViewModel
import jc.highapp.jccv.services.auth.AuthService
import jc.highapp.jccv.user.interactor.UserInteractor
import jc.highapp.jccv.user.model.UserAction
import jc.highapp.jccv.user.model.UserListItem
import jc.highapp.jccv.user.model.UserState
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val userInteractor: UserInteractor,
    private val authService : AuthService): BaseViewModel<UserState>() {

    fun onInit() {
        uiScope.launch {
            state.value = UserState(isLoading = true)
        }
        ioScope.launch {
            val data = userInteractor.execute(authService.getCurrentUserId()
                ?: throw IllegalStateException("User cannot be null at this point!"))
            uiScope.launch {
                state.value = UserState(isLoading = false, items = data)
            }
        }
    }

    fun onItemClick(userAction: UserAction) {

    }
}