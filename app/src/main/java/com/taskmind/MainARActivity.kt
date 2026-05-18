package com.taskmind

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainARActivity : AppCompatActivity() {

    private lateinit var hud: HUDCanvasManager
    private lateinit var gesture: GestureManager
    private lateinit var mic: GlassesMicManager
    private lateinit var industry: IndustryManager
    private lateinit var translator: TranslationEngine
    private lateinit var predictive: PredictiveEngine
    private lateinit var privacy: PrivacyUtils
    private lateinit var billing: BillingManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vuzix_ar)

        hud = HUDCanvasManager(this)
        gesture = GestureManager(this) { handleGesture(it) }
        mic = GlassesMicManager(this) { handleAudioChunk(it) }
        industry = IndustryManager(this)
        translator = TranslationEngine(this)
        predictive = PredictiveEngine(this)
        privacy = PrivacyUtils(this)
        billing = BillingManager(this)

        gesture.initVuzixTouchpad()
        hud.showWelcome("TaskMind Ready – Swipe down for glasses mic")
    }

    private fun handleGesture(action: String) {
        when (action) {
            "swipe_down" -> mic.toggle(industry.currentIndustry)
            "swipe_left" -> industry.cycle(-1)
            "swipe_right" -> industry.cycle(1)
            "hold_menu" -> hud.showIndustryPicker()
        }
        predictive.update(action, industry.currentIndustry)
    }

    private fun handleAudioChunk(pcm: ByteArray) {
        privacy.logIfMedical(industry.currentIndustry, pcm)
        val text = translator.stt.transcribe(pcm)
        val translated = translator.translate(text, industry.currentIndustry)
        val safe = translator.safetyCheck(translated, industry.currentIndustry)
        hud.updateOverlay(safe, industry.getTheme())
        predictive.suggestNext(industry.currentIndustry, text)
    }

    override fun onDestroy() {
        mic.stop()
        super.onDestroy()
    }
}
