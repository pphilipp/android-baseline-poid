package com.poid.baselinepoidapp.architecture.di.viewmodel

import androidx.lifecycle.ViewModelProvider
import com.poid.baselinepoidapp.architecture.ViewModelKey
import com.poid.baselinepoidapp.architecture.ViewModelFactory
import com.poid.baselinepoidapp.presentation.main.MainViewModel
import com.poid.core.base.BaseViewModel
import com.poid.core.di.AppScope
import com.poid.core.logging.LogcatLogger
import com.poid.core.logging.Logger
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun provideLogger(logcatLogger: LogcatLogger): Logger

    @Binds
    @AppScope
    internal abstract fun provideViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun provideMainViewModel(
        viewModel: MainViewModel
    ): BaseViewModel

}