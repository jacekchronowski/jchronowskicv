package jc.highapp.jccv.cv.viewmodel

import jc.highapp.jccv.architecture.BaseViewModel
import jc.highapp.jccv.cv.interactor.CVInteractor
import jc.highapp.jccv.cv.model.CVState
import jc.highapp.jccv.utils.asyncIo
import jc.highapp.jccv.utils.launchUi
import javax.inject.Inject

class CVViewModel @Inject constructor(
    private val CVInteractor: CVInteractor): BaseViewModel<CVState>() {

    fun onInit() {
        launchUi {
            state.value = CVState(isLoading = true)
            state.value = CVState(
                isLoading = false,
                items = asyncIo { CVInteractor.execute() })
        }
    }

}
