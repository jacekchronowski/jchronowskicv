package jc.highapp.jccv.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.constraintlayout.widget.Group
import com.google.android.material.bottomnavigation.BottomNavigationView

fun ViewGroup.inflate(@LayoutRes layoutResId : Int) : View {
    return LayoutInflater.from(context).inflate(layoutResId, this, false)
}

fun Group.setAllOnClickListener(onClick : ()->Unit) {
    referencedIds.forEach { id ->
        rootView.findViewById<View>(id).setOnClickListener {
            onClick()
        }
    }
}

fun View.visible(visible : Boolean) {
    visibility = if(visible) View.VISIBLE else View.GONE
}

fun BottomNavigationView.selectItem(menuItemId: Int) {
    for (i in 0 until menu.size()) {
        menu.getItem(i).isChecked = false
    }
    this.menu.findItem(menuItemId).isChecked = true

}