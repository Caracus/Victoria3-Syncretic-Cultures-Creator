package org.victoria_3_syncretic_cultures_creator.diaspora_project.creators

import org.victoria_3_syncretic_cultures_creator._parser_project.util.addLocalization
import org.victoria_3_syncretic_cultures_creator._parser_project.util.normalize

fun createTraitEntry(type: String, traitKey: String, traitGroupKey: String): String {

    addLocalization(key = "$traitKey.name", value = traitKey.normalize())

    return """
        $traitKey = {
        	type = $type
        	trait_group = $traitGroupKey
        }
    """.trimIndent()
}
