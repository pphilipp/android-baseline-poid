package com.poid.core.di

import android.content.Context
import com.poid.core.base.BaseActivity
import com.poid.core.base.BaseFragment

interface BaseComponent {

    fun inject(baseFragment: BaseFragment)

    fun inject(baseActivity: BaseActivity)

    fun provideAppContext(): Context
}