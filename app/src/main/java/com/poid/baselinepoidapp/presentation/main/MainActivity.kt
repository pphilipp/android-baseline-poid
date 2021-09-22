package com.poid.baselinepoidapp.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.poid.baselinepoidapp.architecture.di.DaggerAppComponent
import com.poid.baselinepoidapp.presentation.main.ui.theme.BaselinePoidAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val remoteDataUseCase = DaggerAppComponent.create().getRemoteDataUseCase()

        setContent {
            Greeting("🟢 ${remoteDataUseCase.execute()}")
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        modifier = Modifier.fillMaxWidth(),
        color = Color.Green
    )
}
