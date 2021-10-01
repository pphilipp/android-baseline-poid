package com.poid.baselinepoidapp.presentation.main

import com.poid.baselinepoidapp.data.DataRepository
import com.poid.core.base.BaseViewModel
import com.poid.core.extantion.logTag
import com.poid.core.logging.Logger
import javax.inject.Inject

class MainViewModel @Inject constructor(
    userRepository: DataRepository,
    logger: Logger
) : BaseViewModel(logger) {

    init {
        log.d(logTag, "init")
    }

    val test = userRepository.getDataRemote()

    override fun onCleared() {
        super.onCleared()
        log.d(logTag, "init")
    }
}