package com.taskmind

import android.content.Context

class TranslationEngine(private val context: Context) {
    val stt = WhisperTinySTT(context)

    fun translate(text: String, industry: String): String {
        val adapter = IndustryManager(context).loadTranslatorForIndustry(industry)
        return adapter.translate(text)
    }

    fun safetyCheck(text: String, industry: String): String {
        return if (industry == "medical") {
            if (SafetyValidator.isHighRisk(text)) "CONFIRM: $text" else text
        } else {
            text
        }
    }
}
package com.taskmind

import android.content.Context

class TranslationEngine(private val context: Context) {
    val stt = WhisperTinySTT(context)

    fun translate(text: String, industry: String): String {
        val adapter = IndustryManager(context).loadTranslatorForIndustry(industry)
        return adapter.translate(text)
    }

    fun safetyCheck(text: String, industry: String): String {
        if (industry == "medical") {
            return if (SafetyValidator.isHighRisk(text)) "CONFIRM: $text" else text
        }
        return text
    }
}
