package com.taskmind

import android.app.Activity

class GestureManager(
    private val activity: Activity,
    private val callback: (String) -> Unit
) {

    fun initVuzixTouchpad() {
        // Initialize touchpad/gesture listeners for Vuzix devices.
        // Call callback("swipe_down"), callback("swipe_left"), etc.
    }
}
package com.taskmind

import android.app.Activity

class GestureManager(private val activity: Activity, private val callback: (String) -> Unit) {
    fun initVuzixTouchpad() {
        // Initialize Vuzix touchpad callbacks and route gestures to `callback`
    }
}
