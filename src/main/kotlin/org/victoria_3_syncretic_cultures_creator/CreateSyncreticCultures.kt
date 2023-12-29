package org.victoria_3_syncretic_cultures_creator


import org.victoria_3_syncretic_cultures_creator.creators.*
import org.victoria_3_syncretic_cultures_creator.logic.calculateCompatibleCultures
import org.victoria_3_syncretic_cultures_creator.logic.createMutuallyExclusiveCulturesMap
import org.victoria_3_syncretic_cultures_creator.models.SyncreticCulture
import org.victoria_3_syncretic_cultures_creator.parsers.getSyncreticCultureConfiguration
import org.victoria_3_syncretic_cultures_creator.utils.createGitHubTableForGameRule
import org.victoria_3_syncretic_cultures_creator.utils.createGitHubTableFromCulturesConfiguration
import org.victoria_3_syncretic_cultures_creator.utils.sortAlphabetically

fun main(args: Array<String>) {

    var syncreticCultureConfiguration = sortAlphabetically(getSyncreticCultureConfiguration())

    syncreticCultureConfiguration = createMutuallyExclusiveCulturesMap(syncreticCultureConfiguration)
    val compatibleCulturesMap: Map<String, Set<String>> = calculateCompatibleCultures(syncreticCultureConfiguration)

    //culture by culture
    syncreticCultureConfiguration.forEach { syncreticCulture: SyncreticCulture ->
        createCulture(syncreticCulture)
        createJournalEntry(syncreticCulture)
        createDecision(syncreticCulture)
        createAddonCultureEvents(syncreticCulture)
        createCultureEvents(syncreticCulture, compatibleCulturesMap.get(syncreticCulture.syncreticCultureName))
    }

    //just once
    createScriptValues()
    createGameRules(syncreticCultureConfiguration)
    createLocalization(syncreticCultureConfiguration)
    createOverwriteLocalization()
    copyStaticDecisions()


    //optional section

    //Use this if you want a table representation for steam
    //createSteamTableFromCulturesConfiguration(syncreticCultureConfiguration)

    //Use this if you want a table representation for github / for example the readme table
    //createGitHubTableFromCulturesConfiguration(syncreticCultureConfiguration)

    //Use this to print a table for the immersive culture game rule setting
    createGitHubTableForGameRule(syncreticCultureConfiguration)

    //Use this to create a list for the syncretic cultures for the modify homelands mod
    //createModifyHomelandsList(syncreticCultureConfiguration)

    println("Done")
}
