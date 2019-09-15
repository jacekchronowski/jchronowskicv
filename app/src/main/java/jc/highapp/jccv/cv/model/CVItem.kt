package jc.highapp.jccv.cv.model

sealed class CVItem {
    data class UserToolItem(val toolsNames : List<String>) : CVItem()
    data class UserLanguageItem(val languageName : String, val level : String) : CVItem()
    data class UserPersonalSkill(val skillssNames : List<String>) : CVItem()
    data class UserProgrammingLanguageItem(val languageName : String, val level : Int) : CVItem()
    data class UserExperienceItem(val timeline : String, val companyName : String, val companyLogoImageUrl : String?) : CVItem()
}