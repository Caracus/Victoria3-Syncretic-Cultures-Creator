package org.victoria_3_syncretic_cultures_creator.creators

import org.victoria_3_syncretic_cultures_creator.utils.printFile
import org.victoria_3_syncretic_cultures_creator.utils.readFileAsText

fun createGameRules() {
    val textOfFile = readFileAsText("src/main/resources/templates/ActualGameRules.txt")

    var text = textOfFile

    printFile("common/game_rules/", "syncretic_cultures_game_rules.txt", text)
}

