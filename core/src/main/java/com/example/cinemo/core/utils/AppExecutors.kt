package com.example.cinemo.core.utils

import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import android.os.Handler
import javax.inject.Inject

class AppExecutors constructor(
    private val diskIO : Executor,
    private val networkIO : Executor,
    private val mainThread : Executor
) {

    @Inject
    constructor(): this(
        Executors.newSingleThreadExecutor(),
        Executors.newFixedThreadPool(THREAD_COUNT),
        MainThreadExecutor()
    )

    fun diskIO(): Executor = diskIO

    fun networkIO(): Executor = networkIO

    fun mainThread(): Executor = mainThread

    private class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())

        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }

    companion object {
        private const val THREAD_COUNT = 3
    }
}