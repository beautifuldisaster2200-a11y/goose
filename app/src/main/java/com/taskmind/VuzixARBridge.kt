package com.taskmind

object VuzixARBridge {
    fun startAudioStream(callback: (ByteArray) -> Unit) {
        // Start the Vuzix audio stream and deliver PCM chunks to callback.
    }

    fun stopAudioStream() {
        // Stop the Vuzix audio stream.
    }
}
package com.taskmind

object VuzixARBridge {
    fun startAudioStream(callback: (ByteArray) -> Unit) {
        // Start the Vuzix or XREAL audio stream and invoke callback for PCM chunks
    }

    fun stopAudioStream() {
        // Stop the audio stream
    }
}
