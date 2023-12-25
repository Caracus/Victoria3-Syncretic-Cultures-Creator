package org.victoria_3_syncretic_cultures_creator.logic

import org.victoria_3_syncretic_cultures_creator.models.SyncreticCulture

fun calculateCompatibleCultures(syncreticCultures: List<SyncreticCulture>): MutableMap<String, MutableSet<String>> {

    val compatibleCulturesMap: MutableMap<String, MutableSet<String>> = mutableMapOf()
    syncreticCultures.forEach { lookedAtCulture ->
        val compatibleCulturesSet: MutableSet<String> = mutableSetOf()

        syncreticCultures.forEach { comparisonCulture ->
            if (comparisonCulture.syncreticCultureName != lookedAtCulture.syncreticCultureName) {
                val sharedCultures = comparisonCulture.baseCultures.toSet().intersect(lookedAtCulture.baseCultures.toSet())
                if (sharedCultures.isNotEmpty()) {
                    compatibleCulturesSet.add(comparisonCulture.syncreticCultureName)
                }
            }
        }
        compatibleCulturesMap[lookedAtCulture.syncreticCultureName] = compatibleCulturesSet
    }

    return compatibleCulturesMap
}
