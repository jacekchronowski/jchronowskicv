package jc.highapp.jccv.services.model

data class User(
    val userId : String = "",
    val firstName : String = "",
    val lastName : String = "",
    val imageUrl : String? = null,
    val position : String = "",
    val description : String = "",
    val twitterId : String = "",
    val githubId : String = "",
    val linkedInId : String = "",
    val phoneNumber : String = "",
    val email : String = "",
    val skypeId : String = "    ",
    val facebookId : String = "")