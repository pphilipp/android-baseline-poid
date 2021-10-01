package com.poid.baselinepoidapp.presentation.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.lifecycleScope
import com.poid.baselinepoidapp.architecture.AppApplication
import com.poid.core.base.BaseActivity
import kotlinx.coroutines.launch

class MainActivity : BaseActivity() {

    private val viewModel by lazy { getViewModel<MainViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeViewModel(viewModel)

        setContent {
            Greeting(name = "🟢 ${viewModel.test}")
        }
    }

    override fun onResume() {
        super.onResume()

        lifecycleScope.launch() {
            viewModel.showProgress()
        }
    }

    override fun inject() {
        AppApplication.applicationComponent.inject(this)
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        color = Color.Green
    )
}
