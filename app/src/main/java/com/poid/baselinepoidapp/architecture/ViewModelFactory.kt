package com.poid.baselinepoidapp.architecture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.poid.core.base.BaseViewModel
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    private val viewModels: MutableMap<Class<out ViewModel>, Provider<BaseViewModel>>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var creator = viewModels[modelClass]
        creator = creator ?: viewModels.entries
            .firstOrNull { modelClass.isAssignableFrom(it.key) }?.value
        creator ?: throw IllegalArgumentException("model class $modelClass not found")
        return creator.get() as T
    }
}