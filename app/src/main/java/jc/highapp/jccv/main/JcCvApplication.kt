package jc.highapp.jccv.main

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import jc.highapp.jccv.di.DaggerApplicationComponent

class JcCvApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        return DaggerApplicationComponent.factory().create(applicationContext)
    }
}
