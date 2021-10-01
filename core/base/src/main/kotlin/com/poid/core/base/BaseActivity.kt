package com.poid.core.base

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.poid.base.R
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var progressDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        /** Need to initialize Dagger state before an attached fragment is created based on
         * the saved instance state after screen rotation
         */
        inject()
        super.onCreate(savedInstanceState)
        progressDialog = AlertDialog.Builder(this, R.style.DialogTransparent).apply {
            setCancelable(false)
            setView(R.layout.progress)
        }.create()

    }

    protected open fun inject() {
        (application as BaseApplication).baseComponent.inject(this)
    }

    inline fun <reified T : BaseViewModel> getViewModel(): T =
        ViewModelProvider(this, viewModelFactory).get(T::class.java)

    /**
     * Should be used for attaching baseViewModel functionality like:
     * - show/hide progress dialog
     *
     */
    fun observeViewModel(viewModel: BaseViewModel) {
        viewModel.onProgressStateFlow
            .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .onEach {
                if (it) {
                    showProgressDialog()
                } else {
                    dismissProgressDialog()
                }
            }.launchIn(lifecycleScope)
    }

    /**
     * show/hide progress dialog
     */
    fun showProgressDialog() {
        progressDialog?.show()
    }

    fun dismissProgressDialog() {
        progressDialog?.dismiss()
    }

}