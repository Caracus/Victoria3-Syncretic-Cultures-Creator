package org.victoria_3_syncretic_cultures_creator.syncretic_cultures.creators

import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.utils.printFile
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.utils.readFileAsText

fun createScriptValues() {
    val textOfFile = readFileAsText("src/main/resources/templates/ActualScriptValues.txt")

    var text = textOfFile

    printFile("common/script_values/", "change_culture_script_values.txt", text)
}

