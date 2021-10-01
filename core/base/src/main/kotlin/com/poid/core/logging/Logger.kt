package com.poid.core.logging

interface Logger {

    fun v(tag: String, message: String?, tr: Throwable? = null)

    fun d(tag: String, message: String?, tr: Throwable? = null)

    fun i(tag: String, message: String?, tr: Throwable? = null)

    fun w(tag: String, message: String?, tr: Throwable? = null)

    fun e(tag: String, message: String?, tr: Throwable? = null)

}