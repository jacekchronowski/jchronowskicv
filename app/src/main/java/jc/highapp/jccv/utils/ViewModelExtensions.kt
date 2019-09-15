package jc.highapp.jccv.utils

import jc.highapp.jccv.architecture.BaseState
import jc.highapp.jccv.architecture.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


fun <S : BaseState> BaseViewModel<S>.launchIo(block : suspend CoroutineScope.() -> Unit) {
    ioScope.launch(block = block)
}

fun <S : BaseState> BaseViewModel<S>.launchUi(block : suspend CoroutineScope.() -> Unit) {
    uiScope.launch(block = block)
}

suspend fun <S : BaseState, R> BaseViewModel<S>.asyncIo(block : suspend CoroutineScope.() -> R) : R{
    return withContext(ioScope.coroutineContext, block)
}