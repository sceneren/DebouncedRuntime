package com.github.sceneren.debounced

import android.util.Log
import android.view.View
import java.lang.ref.WeakReference
import java.util.*
import java.util.concurrent.TimeUnit

/**
 *
 * @Description:    点击事件防抖拦截
 * @Author:         scene
 * @CreateDate:     2022/7/7 12:45
 * @UpdateUser:
 * @UpdateDate:     2022/7/7 12:45
 * @UpdateRemark:
 * @Version:        1.0.0
 */
object TestClickUtils {
    private const val FROZEN_WINDOW_MILLIS = 1000L

    private val viewWeakHashMap: MutableMap<View, FrozenView> = WeakHashMap()

    @JvmStatic
    fun testShouldDoClick(targetView: View): Boolean {
        Log.e("testShouldDoClick", "testShouldDoClick")
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