package com.poid.baselinepoidapp.data

import javax.inject.Inject

class LocalDataSource @Inject constructor(
): DataSource {
    override fun getData() = "Local data"
}