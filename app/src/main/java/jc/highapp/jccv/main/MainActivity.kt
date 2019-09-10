package jc.highapp.jccv.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jc.highapp.jccv.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        bn_view.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.bn_general -> {}
                R.id.bn_experience -> {}
                R.id.bn_portfolio -> {}
            }
            false
        }
    }
}
