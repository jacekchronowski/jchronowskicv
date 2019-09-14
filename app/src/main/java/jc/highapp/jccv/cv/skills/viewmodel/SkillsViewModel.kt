package jc.highapp.jccv.cv.skills.viewmodel

import jc.highapp.jccv.architecture.BaseViewModel
import jc.highapp.jccv.cv.skills.interactor.SkillsInteractor
import jc.highapp.jccv.cv.skills.model.SkillsState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SkillsViewModel @Inject constructor(private val skillsInteractor: SkillsInteractor): BaseViewModel<SkillsState>() {

    fun onInit() {
        uiScope.launch {
            state.value = SkillsState(isLoading = true)
            state.value = SkillsState(
                isLoading = false,
                skills = withContext(Dispatchers.IO) { skillsInteractor.execute() })
        }
    }

}
