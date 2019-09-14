package jc.highapp.jccv.cv.skills.model

import jc.highapp.jccv.architecture.BaseState

data class SkillsState(
    val isLoading : Boolean = false,
    val skills : List<SkillItem> = listOf()) : BaseState
