package jc.highapp.jccv.user.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import jc.highapp.jccv.R

sealed class UserAction(
    val id : String,
    val userActionType: UserActionType,
    @StringRes val userActionNamResId : Int,
    @DrawableRes val userActionDrawableRes : Int) {

    data class Twitter(val twitterId : String) : UserAction(
        twitterId,
        UserActionType.TWITTER,
        R.string.twitter,
        R.drawable.ic_twitter)

    data class Github(val githubId : String) : UserAction(
        githubId,
        UserActionType.GITHUB,
        R.string.github,
        R.drawable.ic_github)

    data class LinkedIn(val linkedInId : String) : UserAction(
        linkedInId,
        UserActionType.LINKEDIN,
        R.string.linkedin,
        R.drawable.ic_linkedin)

    data class Phone(val phoneNumber : String) : UserAction(
        phoneNumber,
        UserActionType.PHONE,
        R.string.phone,
        R.drawable.ic_phone)

    data class Email(val email : String) : UserAction(
        email,
        UserActionType.EMAIL,
        R.string.email,
        R.drawable.ic_mail)

    data class Skype(val skypeId : String) : UserAction(
        skypeId,
        UserActionType.SKYPE,
        R.string.skype,
        R.drawable.ic_skype)

    data class Facebook(val facebookId : String) : UserAction(
        facebookId,
        UserActionType.FACEBOOK,
        R.string.facebook,
        R.drawable.ic_facebook)
}