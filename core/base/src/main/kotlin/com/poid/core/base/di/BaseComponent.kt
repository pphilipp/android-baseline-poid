package com.poid.core.base.di

import android.content.Context
import com.poid.core.base.BaseActivity
import com.poid.core.base.BaseFragment
import dagger.Component

interface BaseComponent {

    fun inject(baseFragment: BaseFragment)

    fun inject(baseActivity: BaseActivity)

    fun provideAppContext(): Context
}