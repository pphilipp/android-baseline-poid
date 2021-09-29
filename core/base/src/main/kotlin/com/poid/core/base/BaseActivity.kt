package com.poid.core.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        /** Need to initialize Dagger state before an attached fragment is created based on
         * the saved instance state after screen rotation
         */
        inject()
        super.onCreate(savedInstanceState)
    }

    protected open fun inject() {
        (application as BaseApplication).baseComponent.inject(this)
    }

    inline fun <reified T : BaseViewModel> getViewModel(): T =
        ViewModelProvider(this, viewModelFactory).get(T::class.java)

}