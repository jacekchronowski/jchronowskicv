package jc.highapp.jccv.cv.skills.model

sealed class SkillItem {

    data class UserToolItem(val toolName : String) : SkillItem()
    data class UserLanguageItem(val languageName : String, val level : String) : SkillItem()
    data class UserPersonalSkill(val skillName : String) : SkillItem()
}