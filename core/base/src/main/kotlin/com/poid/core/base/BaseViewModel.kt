package com.poid.core.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

abstract class BaseViewModel : ViewModel() {

    private val _progressStateFlow = MutableSharedFlow<Boolean>()
    val onProgressStateFlow: SharedFlow<Boolean> = _progressStateFlow

    suspend fun showProgress() {
        _progressStateFlow.emit(true)
    }

    suspend fun hideProgress() {
        _progressStateFlow.emit(true)
    }
}