package com.taskmind

import android.content.Context

interface TranslatorAdapter {
    fun translate(text: String): String
}

open class BaseTranslator : TranslatorAdapter {
    override fun translate(text: String): String = text
}

open class BaseQLoRAAdapter : TranslatorAdapter {
    override fun translate(text: String): String = text
}

class MedicalQLoRAAdapter : TranslatorAdapter {
    override fun translate(text: String): String = "[medical] $text"
}

class MechanicsQLoRAAdapter : TranslatorAdapter {
    override fun translate(text: String): String = "[mechanics] $text"
}

class ConstructionQLoRAAdapter : TranslatorAdapter {
    override fun translate(text: String): String = "[construction] $text"
}

class DiyQLoRAAdapter : TranslatorAdapter {
    override fun translate(text: String): String = "[diy] $text"
}

class LogisticsQLoRAAdapter : TranslatorAdapter {
    override fun translate(text: String): String = "[logistics] $text"
}

class WarehousesQLoRAAdapter : TranslatorAdapter {
    override fun translate(text: String): String = "[warehouses] $text"
}

class TruckDriverQLoRAAdapter : TranslatorAdapter {
    override fun translate(text: String): String = "[truckdriver] $text"
}

class ProgrammerQLoRAAdapter : TranslatorAdapter {
    override fun translate(text: String): String = "[programmer] $text"
}

class CookingQLoRAAdapter : TranslatorAdapter {
    override fun translate(text: String): String = "[cooking] $text"
}

class HobbiesQLoRAAdapter : TranslatorAdapter {
    override fun translate(text: String): String = "[hobbies] $text"
}

class DogTrainerQLoRAAdapter : TranslatorAdapter {
    override fun translate(text: String): String = "[dogtrainer] $text"
}

class MentalHealthQLoRAAdapter : TranslatorAdapter {
    override fun translate(text: String): String = "[mentalhealth] $text"
}

class ParentingQLoRAAdapter : TranslatorAdapter {
    override fun translate(text: String): String = "[parenting] $text"
}

class WhisperTinySTT(context: Context) {
    fun transcribe(pcm: ByteArray): String = ""
}

object SafetyValidator {
    fun isHighRisk(text: String): Boolean = false
}
