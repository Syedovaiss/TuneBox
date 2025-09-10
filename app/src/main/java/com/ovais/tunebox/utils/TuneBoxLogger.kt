package com.ovais.tunebox.utils

import android.annotation.SuppressLint
import timber.log.Timber


interface TuneBoxLogger {
    fun info(message: String)
    fun error(message: String)
    fun error(message: Throwable)
}

class DefaultTuneBoxLogger : Timber.DebugTree(), TuneBoxLogger {
    private companion object {
        private val TAG = TuneBoxLogger::class.java.simpleName
    }

    override fun info(message: String) {
        i("%s:%s", TAG, message)
    }

    override fun error(message: String) {
        e("%s:%s", TAG, message)
    }

    @SuppressLint("ThrowableNotAtBeginning")
    override fun error(message: Throwable) {
        e("%s:%s", TAG, message)
    }
}