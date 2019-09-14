package jc.highapp.jccv.user.interactor

import jc.highapp.jccv.services.users.UserService
import jc.highapp.jccv.user.model.UserListItem
import jc.highapp.jccv.user.model.UserAction
import javax.inject.Inject

class UserInteractor @Inject constructor(private val userService: UserService) {

    suspend fun execute(userId: String): List<UserListItem> {
        val userData = userService.getUserData(userId)
        return listOf(
            UserListItem.Header(
                "${userData.firstName} ${userData.lastName}",
                userData.position,
                userData.imageUrl,
                listOf(
                    UserAction.Twitter(userData.twitterId),
                    UserAction.Github(userData.githubId),
                    UserAction.LinkedIn(userData.linkedInId)
                )
            ),
            UserListItem.Description(userData.description),
            UserListItem.Divider,
            UserListItem.MinorItem(UserAction.Phone(userData.phoneNumber)),
            UserListItem.SmallDivider,
            UserListItem.MinorItem(UserAction.Email(userData.email)),
            UserListItem.SmallDivider,
            UserListItem.MinorItem(UserAction.Skype(userData.skypeId)),
            UserListItem.SmallDivider,
            UserListItem.MinorItem(UserAction.Facebook(userData.facebookId)),
            UserListItem.Divider)
    }
}