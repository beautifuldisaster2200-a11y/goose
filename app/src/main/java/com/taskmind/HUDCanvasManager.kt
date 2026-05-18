package com.taskmind

import android.app.Activity

class HUDCanvasManager(private val activity: Activity) {

    fun showWelcome(message: String) {
        // Display a welcome overlay in the Vuzix HUD canvas
    }

    fun updateOverlay(text: String, theme: String) {
        // Update the HUD overlay with translated/safe content and current theme
    }

    fun showIndustryPicker() {
        // Render an industry picker or premium upgrade prompt
    }

    fun showPaywall(industry: String) {
        // Show purchase prompt for locked premium industries
    }
}
package com.taskmind

import android.app.Activity

class HUDCanvasManager(private val activity: Activity) {
    fun showWelcome(message: String) {
        // Render welcome text in the Vuzix HUD overlay
    }

    fun updateOverlay(text: String, theme: String) {
        // Render translated text and apply the current theme
    }

    fun showIndustryPicker() {
        // Show industry picker overlay with purchase options
    }

    fun showPaywall(pack: String) {
        // Show paywall prompt for premium industry packs
    }
}
