package com.poid.core.base

import android.app.Application
import com.poid.core.base.di.BaseComponent

abstract class BaseApplication : Application() {

    abstract val baseComponent: BaseComponent

    abstract fun <T> getProvisionComponent(): T
}