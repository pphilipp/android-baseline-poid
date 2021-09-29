package com.poid.baselinepoidapp.presentation.main

import com.poid.baselinepoidapp.data.DataRepository
import com.poid.core.base.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    userRepository: DataRepository
) : BaseViewModel() {

    val test = userRepository.getDataRemote()
}