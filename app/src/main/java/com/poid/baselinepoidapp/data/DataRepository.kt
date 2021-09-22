package com.poid.baselinepoidapp.data

import javax.inject.Inject

class DataRepository @Inject constructor(
    private val local: LocalDataSource,
    private val remote: RemoteDataSource,
) {

    fun getDataLocal() = local.getData()

    fun getDataRemote() = remote.getData()
}