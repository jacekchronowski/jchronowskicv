package jc.highapp.jccv.cv.model

import jc.highapp.jccv.architecture.BaseState

data class CVState(
    val isLoading : Boolean = false,
    val items : List<CVItem> = listOf()) : BaseState
