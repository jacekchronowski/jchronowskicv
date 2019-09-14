package jc.highapp.jccv.architecture

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

abstract class BaseViewModel<S : BaseState> : ViewModel() {

    protected val ioScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    protected val uiScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    val state: MutableLiveData<S> = MutableLiveData()

    fun onDestroy() {
        ioScope.coroutineContext.cancel()
        uiScope.coroutineContext.cancel()
    }

}