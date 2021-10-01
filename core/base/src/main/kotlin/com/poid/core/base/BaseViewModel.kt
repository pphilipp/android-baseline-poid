package com.poid.core.base

import androidx.lifecycle.ViewModel
import com.poid.core.logging.Logger
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

abstract class BaseViewModel(
    val log: Logger
) : ViewModel() {

    private val _progressStateFlow = MutableSharedFlow<Boolean>()
    val onProgressStateFlow: SharedFlow<Boolean> = _progressStateFlow

    suspend fun showProgress() {
        _progressStateFlow.emit(true)
    }

    suspend fun hideProgress() {
        _progressStateFlow.emit(true)
    }
}