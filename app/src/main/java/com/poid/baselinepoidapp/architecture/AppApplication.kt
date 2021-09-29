package com.poid.baselinepoidapp.architecture

import com.poid.core.base.BaseApplication
import com.poid.baselinepoidapp.BuildConfig
import com.poid.baselinepoidapp.architecture.di.ApplicationComponent
import com.poid.baselinepoidapp.architecture.di.DaggerApplicationComponent
import com.poid.baselinepoidapp.architecture.di.module.ApplicationModule

class AppApplication : BaseApplication() {

    companion object {
        @JvmStatic
        lateinit var applicationComponent: ApplicationComponent
            private set
    }

    override val baseComponent: ApplicationComponent
        get() = applicationComponent

    private val isTestBuild
        get() = BuildConfig.BUILD_TYPE == "debug" || BuildConfig.BUILD_TYPE == "qa"

    @Suppress("UNCHECKED_CAST")
    override fun <T> getProvisionComponent(): T = applicationComponent as T

    override fun onCreate() {
        super.onCreate()
        initDaggerAppComponent()
    }

    private fun initDaggerAppComponent() {
        val builder: ApplicationComponent.Builder = DaggerApplicationComponent.builder()
        applicationComponent = builder.appModule(ApplicationModule(this)).build()
        applicationComponent.inject(this)
    }

}