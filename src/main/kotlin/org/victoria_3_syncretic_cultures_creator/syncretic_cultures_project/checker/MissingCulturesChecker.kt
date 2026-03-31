package org.victoria_3_syncretic_cultures_creator.syncretic_cultures_project.checker

import org.victoria_3_syncretic_cultures_creator._parser_project.parser.parseMap
import org.victoria_3_syncretic_cultures_creator._parser_project.util.ResourceReader.readAndRemoveComments
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.models.SyncreticCulture

fun checkCultureConflicts(syncreticCultures: List<SyncreticCulture>) {
    val usedCultures = mutableSetOf<String>()

    syncreticCultures.forEach { culture ->
        usedCultures.addAll(culture.baseCultures.toSet())
        usedCultures.addAll(culture.optionalCultures.toSet())
    }

    val rawCulturesText = readAndRemoveComments("gameFiles/common/cultures/00_cultures.txt")

    val vanillaCultures = parseMap(rawCulturesText).keys.toSet()

    // check cultures not yet mapped
    // ignore cringe promethean from Helloween special
    vanillaCultures
        .minus("promethean")
        .forEach { vanillaCulture ->
        if (vanillaCulture !in usedCultures) {
            println("Unused culture: $vanillaCulture")
        }
    }

    // check cultures referenced but not existing in vanilla
    usedCultures.forEach { usedCulture ->
        if (usedCulture !in vanillaCultures) {
            println("Referenced culture not in vanilla: $usedCulture")
        }
    }

    // check syncretic culture key being unique compared to vanilla keys
    syncreticCultures.forEach { culture ->
        if (culture.syncreticCultureName in vanillaCultures) {
            println("Syncretic culture key conflicts with vanilla: ${culture.syncreticCultureName}")
        }
    }
}