package org.victoria_3_syncretic_cultures_creator._parser_project.util.creators

import org.victoria_3_syncretic_cultures_creator._parser_project.util.LocalizationCreator
import org.victoria_3_syncretic_cultures_creator._parser_project.util.normalize

fun createTraitGroupEntry(localizationCreator: LocalizationCreator, type: String, traitGroupName: String, traitKeySuffix: String): String {

    val traitGroupLocalization = "$traitKeySuffix $type group".normalize()

    localizationCreator.pushLocalization(key = traitGroupName, value = traitGroupLocalization)

    return """
        $traitGroupName = {
            type = $type
        }
    """.trimIndent()
}
