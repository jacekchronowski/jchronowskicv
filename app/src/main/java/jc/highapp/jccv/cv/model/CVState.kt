package jc.highapp.jccv.cv.model

import jc.highapp.jccv.architecture.BaseState

data class CVState(
    val isLoading : Boolean = false,
    val skills : List<CVItem> = listOf()) : BaseState
