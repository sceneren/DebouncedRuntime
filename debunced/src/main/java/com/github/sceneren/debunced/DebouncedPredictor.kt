package com.github.sceneren.debunced

import android.view.View
import java.lang.ref.WeakReference
import java.util.*
import java.util.concurrent.TimeUnit

object DebouncedPredictor {
    private const val FROZEN_WINDOW_MILLIS = 700L

    private val viewWeakHashMap: MutableMap<View, FrozenView> = WeakHashMap()

    @JvmStatic
    fun shouldDoClick(targetView: View): Boolean {
        var frozenView = viewWeakHashMap[targetView]
        val now = now()
        if (frozenView == null) {
            frozenView = FrozenView(targetView)
            frozenView.setFrozenWindow(now + FROZEN_WINDOW_MILLIS)
            viewWeakHashMap[targetView] = frozenView
            return true
        }
        if (now >= frozenView.frozenWindowTime) {
            frozenView.setFrozenWindow(now + FROZEN_WINDOW_MILLIS)
            return true
        }
        return false
    }

    private fun now(): Long {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime())
    }

    private class FrozenView constructor(referent: View?) :
        WeakReference<View?>(referent) {
        var frozenWindowTime: Long = 0
            private set

        fun setFrozenWindow(expirationTime: Long) {
            frozenWindowTime = expirationTime
        }
    }
}