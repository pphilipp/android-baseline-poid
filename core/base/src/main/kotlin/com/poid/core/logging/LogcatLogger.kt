package com.poid.core.logging

import android.util.Log
import com.poid.base.BuildConfig
import javax.inject.Inject

class LogcatLogger @Inject constructor() : Logger {

    override fun v(tag: String, message: String?, tr: Throwable?) {
        if (BuildConfig.GENERAL_LOGGING_ENABLED) Log.v("🔵 $tag", message, tr)
    }

    override fun d(tag: String, message: String?, tr: Throwable?) {
        if (BuildConfig.GENERAL_LOGGING_ENABLED) Log.d("🟢 $tag", message, tr)
    }

    override fun i(tag: String, message: String?, tr: Throwable?) {
        if (BuildConfig.GENERAL_LOGGING_ENABLED) Log.i("🟡 $tag", message, tr)
    }

    override fun w(tag: String, message: String?, tr: Throwable?) {
        if (BuildConfig.GENERAL_LOGGING_ENABLED) Log.w("🟠 $tag", message, tr)
    }

    override fun e(tag: String, message: String?, tr: Throwable?) {
        if (BuildConfig.GENERAL_LOGGING_ENABLED) Log.e("🔴 $tag", message, tr)
    }
}