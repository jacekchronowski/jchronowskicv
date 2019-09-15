package jc.highapp.jccv

import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import jc.highapp.jccv.services.model.User
import jc.highapp.jccv.services.users.UserService
import jc.highapp.jccv.user.interactor.UserInteractor
import jc.highapp.jccv.user.model.UserActionType
import jc.highapp.jccv.user.model.UserListItem
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class UserInteractorTest {

    @MockK
    lateinit var userService: UserService

    lateinit var sut : UserInteractor

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        sut = UserInteractor(userService)
    }

    @Test
    fun testHeaderInfoNameValid() = runBlocking {

        coEvery {
            userService.getUserData("1")
        } returns User(firstName = "Mark", lastName = "Clark")

        val data = sut.execute("1")
        val header = data.find { it is UserListItem.Header }?.let { it as? UserListItem.Header}

        assert(header?.name == "Mark Clark")
    }

    @Test
    fun testHeaderInfoPositionValid() = runBlocking {

        coEvery {
            userService.getUserData("1")
        } returns User(position = "Developer" )

        val data = sut.execute("1")
        val header = data.find { it is UserListItem.Header }?.let { it as? UserListItem.Header}

        assert(header?.position == "Developer")
    }

    @Test
    fun testHeaderInfoActionsCount3() = runBlocking {

        coEvery {
            userService.getUserData("1")
        } returns User(position = "Developer" )

        val data = sut.execute("1")
        val header = data.find { it is UserListItem.Header }?.let { it as? UserListItem.Header}

        assert(header?.actions?.size == 3)
    }

    @Test
    fun testHeaderInfoActionsValidIds() = runBlocking {

        coEvery {
            userService.getUserData("1")
        } returns User(position = "Developer", twitterId = "twitterId", githubId = "githubId", linkedInId = "linkedInId")

        val data = sut.execute("1")
        val header = data.find { it is UserListItem.Header }?.let { it as? UserListItem.Header}

        assert(header?.actions?.find { it.userActionType == UserActionType.TWITTER && it.id ==  "twitterId"} != null)
        assert(header?.actions?.find { it.userActionType == UserActionType.GITHUB &&it.id ==  "githubId"} != null)
        assert(header?.actions?.find { it.userActionType == UserActionType.LINKEDIN &&it.id ==  "linkedInId"} != null)
    }

    @Test
    fun testDescriptionAvailable() = runBlocking {

        coEvery {
            userService.getUserData("1")
        } returns User(description = "desc")

        val data = sut.execute("1")
        val description = data.find { it is UserListItem.Description }?.let { it as? UserListItem.Description}

        assert(description?.description == "desc")
    }

    @Test
    fun testPhoneNumberAvailable() = runBlocking {

        coEvery {
            userService.getUserData("1")
        } returns User(phoneNumber = "423423")

        val data = sut.execute("1")

        assert(data.any {
            it is UserListItem.MinorItem &&
                    it.userAction.userActionType == UserActionType.PHONE &&
                    it.userAction.id == "423423" })
    }

    @Test
    fun testEmailAvailable() = runBlocking {

        coEvery {
            userService.getUserData("1")
        } returns User(email = "ja@gmail.com")

        val data = sut.execute("1")

        assert(data.any { it is UserListItem.MinorItem &&
                it.userAction.userActionType == UserActionType.EMAIL &&
                it.userAction.id == "ja@gmail.com" })
    }

    @Test
    fun testSkypeAvailable() = runBlocking {

        coEvery {
            userService.getUserData("1")
        } returns User(skypeId = "shf_f1")

        val data = sut.execute("1")

        assert(data.any {
            it is UserListItem.MinorItem &&
                    it.userAction.userActionType == UserActionType.SKYPE &&
                    it.userAction.id == "shf_f1" })
    }

    @Test
    fun testFacebookAvailable() = runBlocking {

        coEvery {
            userService.getUserData("1")
        } returns User(facebookId = "fb_fb_1")

        val data = sut.execute("1")

        assert(data.any { it is UserListItem.MinorItem &&
                it.userAction.userActionType == UserActionType.FACEBOOK &&
                it.userAction.id == "fb_fb_1" })
    }
}