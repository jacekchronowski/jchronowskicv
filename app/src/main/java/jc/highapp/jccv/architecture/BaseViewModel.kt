package jc.highapp.jccv.architecture

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<S : BaseState> : ViewModel() {

    val state: MutableLiveData<S> = MutableLiveData()

}