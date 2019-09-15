package jc.highapp.jccv

import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.MockK
import jc.highapp.jccv.cv.interactor.CVInteractor
import jc.highapp.jccv.cv.model.CVItem
import jc.highapp.jccv.services.auth.AuthService
import jc.highapp.jccv.services.model.*
import jc.highapp.jccv.services.users.UserService
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

class CvInteractorTest {

    @MockK
    lateinit var authService: AuthService
    @MockK
    lateinit var userService: UserService

    lateinit var sut: CVInteractor

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        coEvery { authService.getCurrentUserId() } returns "1"
        coEvery { userService.getUserTools("1") } returns listOf()
        coEvery { userService.getUserLanguages("1") } returns listOf()
        coEvery { userService.getUserPersonalSkills("1") } returns listOf()
        coEvery { userService.getUserProgrammingLanguages("1") } returns listOf()
        coEvery { userService.getUserExperience("1") } returns listOf()

        sut = CVInteractor(authService, userService)
    }

    @Test
    fun testReturnNoData() = runBlocking {
        val data = sut.execute()
        assert(data.isEmpty())
    }

    @Test
    fun testReturnCheckTools() = runBlocking {
        coEvery { userService.getUserTools("1") } returns listOf(Tool("1", "Android Studio"))
        val data = sut.execute()
        assert(data.contains(CVItem.UserToolItem(listOf("Android Studio"))))
    }

    @Test
    fun testReturnCheckLanguages() = runBlocking {
        coEvery { userService.getUserLanguages("1") } returns listOf(Language("1", "English", "Intermediate"))
        val data = sut.execute()
        assert(data.contains(CVItem.UserLanguageItem("English","Intermediate")))
    }

    @Test
    fun testReturnCheckPersonalSkills() = runBlocking {
        coEvery { userService.getUserPersonalSkills("1") } returns listOf(PersonalSkill("1", "Self Confident"))
        val data = sut.execute()
        assert(data.contains(CVItem.UserPersonalSkill(listOf("Self Confident"))))
    }

    @Test
    fun testReturnCheckProgrammingLanguages() = runBlocking {
        coEvery { userService.getUserProgrammingLanguages("1") } returns listOf(ProgrammingLanguage("1", "Java", 3))
        val data = sut.execute()
        assert(data.contains(CVItem.UserProgrammingLanguageItem("Java", 3)))
    }

    @Test
    fun testReturnCheckExperience() = runBlocking {
        coEvery { userService.getUserExperience("1") } returns listOf(Experience("1", "II 2018", "IV 2019", "Google", null))
        val data = sut.execute()
        assert(data.contains(CVItem.UserExperienceItem("II 2018 - IV 2019", "Google", null)))
    }
}