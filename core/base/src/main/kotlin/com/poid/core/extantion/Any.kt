package com.poid.core.extantion

val Any.logTag: String
    get() = this::class.java.simpleName
