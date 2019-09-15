package jc.highapp.jccv

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.slot
import io.mockk.verify
import jc.highapp.jccv.plugins.BottomNavigationPlugin
import jc.highapp.jccv.plugins.LoadingPlugin
import jc.highapp.jccv.user.binding.UserViewBinding
import jc.highapp.jccv.user.model.UserAction
import jc.highapp.jccv.user.model.UserListItem
import jc.highapp.jccv.user.model.UserState
import jc.highapp.jccv.user.viewcontroller.UserViewController
import jc.highapp.jccv.user.viewmodel.UserViewModel
import org.junit.Before
import org.junit.Test

class UserViewControllerTest {

    lateinit var sut: UserViewController

    @MockK(relaxed = true)
    lateinit var viewModel: UserViewModel
    @MockK(relaxed = true)
    lateinit var viewBinding: UserViewBinding
    @MockK(relaxed = true)
    lateinit var loadingPlugin: LoadingPlugin
    @MockK(relaxed = true)
    lateinit var bottomNavigationPlugin: BottomNavigationPlugin

    @Before
    fun setUp() {

        MockKAnnotations.init(this)
        sut = UserViewController(loadingPlugin, bottomNavigationPlugin)
        sut.attachViewBinding(viewBinding)
        sut.attachViewModel(viewModel)
    }

    @Test
    fun testSetupViewCheckPlugins() {
        sut.setupView()
        assert(sut.plugins.isNotEmpty())
    }

    @Test
    fun testSetupViewShowNavigationView() {
        sut.setupView()
        verify { bottomNavigationPlugin.showBottomNavigationBar(true) }
    }

    @Test
    fun testSetupViewSetupUserList() {
        sut.setupView()
        verify { viewBinding.setupList(any()) }
    }

    @Test
    fun testSetupViewModelOnInit() {
        sut.setupView()
        verify { viewModel.onInit() }
    }

    @Test
    fun testRenderShowLoading() {
        sut.render(UserState(isLoading = true))
        verify { loadingPlugin.showLoading(true) }
    }

    @Test
    fun testRenderHideLoading() {
        sut.render(UserState(isLoading = false))
        verify { loadingPlugin.showLoading(false) }
    }

    @Test
    fun testRenderUpdateList() {
        val items = listOf(UserListItem.Header(
            "John",
            "Developer",
            null,
            listOf()
        ))

        sut.render(UserState(items = items))
        verify { viewBinding.setItemsList(items)}
    }

}