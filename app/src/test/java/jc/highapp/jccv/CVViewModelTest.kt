package jc.highapp.jccv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import jc.highapp.jccv.cv.interactor.CVInteractor
import jc.highapp.jccv.cv.model.CVItem
import jc.highapp.jccv.cv.model.CVState
import jc.highapp.jccv.cv.viewmodel.CVViewModel
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
class CVViewModelTest {

    @MockK
    lateinit var cvInteractor: CVInteractor
    @MockK(relaxed = true)
    lateinit var observer: Observer<CVState>

    @get:Rule
    val rule = InstantTaskExecutorRule()

    lateinit var sut: CVViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        Dispatchers.setMain(Dispatchers.IO)
        sut = CVViewModel(cvInteractor)
        sut.state.observeForever(observer)
    }

    @After
    fun tearDown() {
        sut.state.removeObserver(observer)
        Dispatchers.resetMain()
    }

    @Test
    fun testChangingStates() =  runBlocking {

        val elements = listOf(CVItem.UserProgrammingLanguageItem("Java", 3))

        coEvery {
            cvInteractor.execute()
        } returns elements

        sut.onInit()

        verify {
            observer.onChanged(CVState(isLoading = true))
            observer.onChanged(CVState(isLoading = false, items = elements))
        }

    }

}