package com.poid.baselinepoidapp.data

import javax.inject.Inject

class RemoteDataSource  @Inject constructor(
): DataSource {
    override fun getData() = "Remote data"
}