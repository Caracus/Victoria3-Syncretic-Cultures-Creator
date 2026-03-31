package org.victoria_3_syncretic_cultures_creator.syncretic_cultures.creators

import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.models.SyncreticCulture
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.utils.createGameRuleBlock
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.utils.printFile
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.utils.readFileAsText

fun createGameRules(syncreticCultureConfiguration: List<SyncreticCulture>) {
    val textOfFile = readFileAsText("src/main/resources/templates/ActualGameRules.txt")

    var text = textOfFile

    text += createGameRuleBlock(0, syncreticCultureConfiguration)

    printFile("common/game_rules/", "syncretic_cultures_game_rules.txt", text)
}

