package jc.highapp.jccv.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import jc.highapp.jccv.R

fun FragmentActivity?.replaceFragment(fragment : Fragment) {
    this?.supportFragmentManager
        ?.beginTransaction()
        ?.replace(R.id.fragment_container, fragment, fragment.javaClass.simpleName)
        ?.commit()
}