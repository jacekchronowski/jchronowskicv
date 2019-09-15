package jc.highapp.jccv

import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import jc.highapp.jccv.cv.model.CVItem
import jc.highapp.jccv.cv.model.CVState
import jc.highapp.jccv.cv.viewbinding.CVViewBinding
import jc.highapp.jccv.cv.viewcontroller.CVViewController
import jc.highapp.jccv.cv.viewmodel.CVViewModel
import jc.highapp.jccv.plugins.BottomNavigationPlugin
import jc.highapp.jccv.plugins.LoadingPlugin
import org.junit.Before
import org.junit.Test

class CVControllerTest {

    lateinit var sut: CVViewController

    @MockK(relaxed = true)
    lateinit var viewModel: CVViewModel
    @MockK(relaxed = true)
    lateinit var viewBinding: CVViewBinding
    @MockK(relaxed = true)
    lateinit var loadingPlugin: LoadingPlugin
    @MockK(relaxed = true)
    lateinit var bottomNavigationPlugin: BottomNavigationPlugin


    @Before
    fun setUp() {

        MockKAnnotations.init(this)
        sut = CVViewController(loadingPlugin, bottomNavigationPlugin)
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
        verify { viewBinding.setupList() }
    }

    @Test
    fun testSetupViewModelOnInit() {
        sut.setupView()
        verify { viewModel.onInit() }
    }

    @Test
    fun testRenderShowLoading() {
        sut.render(CVState(isLoading = true))
        verify { loadingPlugin.showLoading(true) }
    }

    @Test
    fun testRenderHideLoading() {
        sut.render(CVState(isLoading = false))
        verify { loadingPlugin.showLoading(false) }
    }

    @Test
    fun testRenderUpdateList() {
        val items = listOf(CVItem.UserLanguageItem(
            "English",
            "Intermediate"
        ))
        
        sut.render(CVState(items = items))
        verify { viewBinding.setListItems(items)}
    }

}