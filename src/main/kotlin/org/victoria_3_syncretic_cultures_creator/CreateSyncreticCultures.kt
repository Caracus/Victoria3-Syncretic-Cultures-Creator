package org.victoria_3_syncretic_cultures_creator


import org.victoria_3_syncretic_cultures_creator.creators.*
import org.victoria_3_syncretic_cultures_creator.parsers.customFiles.getSyncreticCultureConfiguration
import org.victoria_3_syncretic_cultures_creator.utils.createGitHubTableForGameRule
import org.victoria_3_syncretic_cultures_creator.utils.createGitHubTableFromCulturesConfiguration
import org.victoria_3_syncretic_cultures_creator.utils.printSetInHumanReadableForm

const val patchVersion = "1-2-7"

fun main(args: Array<String>) {

    val syncreticCultureConfiguration = getSyncreticCultureConfiguration()

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

    //Use this if you want a table representation for github / for example the radme table
    createGitHubTableFromCulturesConfiguration(syncreticCultureConfiguration)

    //Use this to print a table for the immersive culture game rule setting
    createGitHubTableForGameRule(syncreticCultureConfiguration)

    println("Done")
}
