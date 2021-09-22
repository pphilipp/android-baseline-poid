package com.poid.baselinepoidapp.architecture.di

import com.poid.baselinepoidapp.architecture.di.module.DataModule
import com.poid.baselinepoidapp.domain.GetRemoteDataUseCase
import dagger.Component

@Component(modules = [
    DataModule::class
])
interface AppComponent {

    fun getRemoteDataUseCase() : GetRemoteDataUseCase
}