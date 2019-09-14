package jc.highapp.jccv.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.HasSupportFragmentInjector
import jc.highapp.jccv.R
import jc.highapp.jccv.navigation.Navigator
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var navigator: Navigator

    private var mainViewController : MainViewController? = null
    private var mainViewBinding : MainViewBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigator.bindRoot(this)
        mainViewBinding = MainViewBindingImpl()
        mainViewBinding?.attachView(this)
        mainViewController = MainViewController(navigator)
        mainViewController?.setupView(mainViewBinding)
    }

    override fun onDestroy() {
        super.onDestroy()
        mainViewController?.detachView()
        mainViewController = null
        mainViewBinding?.detachView()
        mainViewBinding = null
        navigator.unbindRoot()
    }
}
