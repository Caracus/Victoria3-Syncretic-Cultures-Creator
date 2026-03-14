package org.victoria_3_syncretic_cultures_creator.diaspora_project.creators

import org.victoria_3_syncretic_cultures_creator._parser_project.util.LocalizationCreator
import org.victoria_3_syncretic_cultures_creator._parser_project.util.normalize

fun createTraitEntry(localizationCreator: LocalizationCreator, type: String, traitKey: String, traitGroupKey: String): String {

    localizationCreator.pushLocalization(key = "$traitKey", value = traitKey.normalize())

    return """
        $traitKey = {
        	type = $type
        	trait_group = $traitGroupKey
        }
    """.trimIndent()
}
