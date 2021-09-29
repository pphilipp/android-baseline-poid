package com.poid.baselinepoidapp.architecture.di

import com.poid.baselinepoidapp.architecture.di.module.ApplicationModule
import com.poid.baselinepoidapp.architecture.AppApplication
import com.poid.baselinepoidapp.architecture.di.viewmodel.ViewModelModule
import com.poid.baselinepoidapp.presentation.main.MainActivity
import com.poid.core.base.di.AppScope
import com.poid.core.base.di.BaseComponent
import dagger.Component

@AppScope
@Component(
    modules = [
        ApplicationModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent :
    BaseComponent {
    /**
     * @ApplicationComponent - used for attaching factories
     * to @AppScope fragments, activities, services.
     */
    fun inject(app: AppApplication)
    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {
        fun appModule(module: ApplicationModule): Builder
        fun build(): ApplicationComponent
    }
}