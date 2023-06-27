package org.victoria_3_syncretic_cultures_creator


import org.victoria_3_syncretic_cultures_creator.creators.*
import org.victoria_3_syncretic_cultures_creator.logic.createMutuallyExclusiveCulturesMap
import org.victoria_3_syncretic_cultures_creator.parsers.getSyncreticCultureConfiguration
import org.victoria_3_syncretic_cultures_creator.utils.createGitHubTableForGameRule
import org.victoria_3_syncretic_cultures_creator.utils.createGitHubTableFromCulturesConfiguration

fun main(args: Array<String>) {

    var syncreticCultureConfiguration = getSyncreticCultureConfiguration()

    syncreticCultureConfiguration = createMutuallyExclusiveCulturesMap(syncreticCultureConfiguration)

    syncreticCultureConfiguration.forEach { syncreticCulture ->
        createCulture(syncreticCulture)
        createJournalEntry(syncreticCulture)
        createDecision(syncreticCulture)
        createAddonCultureEvents(syncreticCulture)
        createCultureEvents(syncreticCulture)
        createScriptValues()
        createGameRules()
    }

    createLocalization(syncreticCultureConfiguration)

    //Use this if you want a table representation for steam
    //createSteamTableFromCulturesConfiguration(syncreticCultureConfiguration)

    //Use this if you want a table representation for github / for example the readme table
    createGitHubTableFromCulturesConfiguration(syncreticCultureConfiguration)

    //Use this to print a table for the immersive culture game rule setting
    createGitHubTableForGameRule(syncreticCultureConfiguration)

    println("Done")
}
