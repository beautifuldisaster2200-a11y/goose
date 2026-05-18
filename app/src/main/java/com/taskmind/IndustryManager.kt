package com.taskmind

import android.content.Context

class IndustryManager(private val context: Context) {

    var currentIndustry = "base"
        private set

    private val unlocked = mutableSetOf("base")

    val industries = listOf(
        "medical", "mechanics", "construction", "diy", "logistics",
        "warehouses", "truckdriver", "programmer", "cooking", "hobbies",
        "dogtrainer", "mentalhealth", "parenting"
    )

    fun isUnlocked(industry: String): Boolean =
        unlocked.contains(industry) || BillingManager.hasPurchased(industry)

    fun loadTranslatorForIndustry(industry: String): TranslatorAdapter {
        if (!isUnlocked(industry) && industry != "base") {
            return BaseTranslator()
        }

        return when (industry) {
            "medical" -> MedicalQLoRAAdapter()
            "mechanics" -> MechanicsQLoRAAdapter()
            "construction" -> ConstructionQLoRAAdapter()
            "diy" -> DiyQLoRAAdapter()
            "logistics" -> LogisticsQLoRAAdapter()
            "warehouses" -> WarehousesQLoRAAdapter()
            "truckdriver" -> TruckDriverQLoRAAdapter()
            "programmer" -> ProgrammerQLoRAAdapter()
            "cooking" -> CookingQLoRAAdapter()
            "hobbies" -> HobbiesQLoRAAdapter()
            "dogtrainer" -> DogTrainerQLoRAAdapter()
            "mentalhealth" -> MentalHealthQLoRAAdapter()
            "parenting" -> ParentingQLoRAAdapter()
            else -> BaseQLoRAAdapter()
        }
    }

    fun cycle(direction: Int) {
        val idx = industries.indexOf(currentIndustry).takeIf { it >= 0 } ?: 0
        currentIndustry = industries[(idx + direction + industries.size) % industries.size]
    }

    fun getTheme(): String = currentIndustry
}
