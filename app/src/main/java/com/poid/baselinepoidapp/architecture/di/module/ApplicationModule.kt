package com.poid.baselinepoidapp.architecture.di.module

import android.content.Context
import android.os.Vibrator
import com.poid.baselinepoidapp.architecture.AppApplication
import com.poid.core.di.AppScope
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application: AppApplication) {
    @Provides
    @AppScope
    fun provideApplicationContext(): Context = application

    @Provides
    @AppScope
    fun provideVibrator(
        context: Context
    ) = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
}