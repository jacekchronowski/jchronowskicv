package jc.highapp.jccv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import jc.highapp.jccv.services.auth.AuthService
import jc.highapp.jccv.user.interactor.UserInteractor
import jc.highapp.jccv.user.model.UserListItem
import jc.highapp.jccv.user.model.UserState
import jc.highapp.jccv.user.viewmodel.UserViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class UserViewModelTest {

    @MockK
    lateinit var authService: AuthService
    @MockK
    lateinit var userInteractor: UserInteractor
    @MockK(relaxed = true)
    lateinit var observer: Observer<UserState>

    @get:Rule
    val rule = InstantTaskExecutorRule()

    lateinit var sut: UserViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        Dispatchers.setMain(Dispatchers.IO)
        sut = UserViewModel(userInteractor, authService)
        sut.state.observeForever(observer)
    }

    @After
    fun tearDown() {
        sut.state.removeObserver(observer)
        Dispatchers.resetMain()
    }

    @Test
    fun testChangingStates() =  runBlocking {

        val elements = listOf(UserListItem.Header(
            name = "John",
            position = "Developer",
            imageUrl = null,
            actions = listOf()
        ))

        coEvery {
            userInteractor.execute("1")
        } returns elements

        coEvery {
            authService.getCurrentUserId()
        } returns "1"

        sut.onInit()

        verify {
            observer.onChanged(UserState(isLoading = true))
            observer.onChanged(UserState(isLoading = false, items = elements))
        }

    }

}