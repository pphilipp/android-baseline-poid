package com.poid.baselinepoidapp.architecture.di.module

import com.poid.baselinepoidapp.data.DataSource
import com.poid.baselinepoidapp.data.RemoteDataSource
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @Binds
    fun  bindDataRemote(dataSource: RemoteDataSource): DataSource
}