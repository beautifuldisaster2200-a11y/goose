package com.taskmind

import android.content.Context

class GlassesMicManager(
    private val context: Context,
    private val onChunk: (ByteArray) -> Unit
) {
    private var isRunning = false

    fun toggle(industry: String) {
        isRunning = !isRunning
        if (isRunning) start(industry) else stop()
    }

    private fun start(industry: String) {
        VuzixARBridge.startAudioStream { pcm -> onChunk(pcm) }
    }

    fun stop() {
        isRunning = false
        VuzixARBridge.stopAudioStream()
    }
}
package com.taskmind

import android.content.Context

class GlassesMicManager(private val context: Context, private val onChunk: (ByteArray) -> Unit) {
    private var isRunning = false

    fun toggle(industry: String) {
        isRunning = !isRunning
        if (isRunning) {
            start(industry)
        } else {
            stop()
        }
    }

    private fun start(industry: String) {
        VuzixARBridge.startAudioStream { pcm -> onChunk(pcm) }
    }

    fun stop() {
        VuzixARBridge.stopAudioStream()
    }
}
