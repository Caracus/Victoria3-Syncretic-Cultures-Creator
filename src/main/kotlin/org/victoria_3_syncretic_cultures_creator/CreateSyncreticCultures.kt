package org.victoria_3_syncretic_cultures_creator


import org.victoria_3_syncretic_cultures_creator.creators.*
import org.victoria_3_syncretic_cultures_creator.parsers.customFiles.getSyncreticCultureConfiguration
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
    }

    createLocalization(syncreticCultureConfiguration)

    //Use this if you want a table representation for steam
    //createSteamTableFromCulturesConfiguration(syncreticCultureConfiguration)

    //Use this if you want a table representation for github
    createGitHubTableFromCulturesConfiguration(syncreticCultureConfiguration)

    println("Done")
}
