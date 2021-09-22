package com.poid.baselinepoidapp.domain

import com.poid.baselinepoidapp.data.DataRepository
import javax.inject.Inject

class GetRemoteDataUseCase @Inject constructor(
    private val dataRepository: DataRepository
) {

    fun execute() = dataRepository.getDataRemote()
}