package org.victoria_3_syncretic_cultures_creator

import org.victoria_3_syncretic_cultures_creator._parser_project.util.ResourceReader.readAndRemoveComments
import org.victoria_3_syncretic_cultures_creator.diaspora_project.creators.createDiasporaCultures
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.creators.copyManualLocalization
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.creators.copyStaticDecisions
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.creators.copyStaticEvents
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.creators.createAddonCultureEvents
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.creators.createCulture
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.creators.createCultureEvents
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.creators.createDecision
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.creators.createGameRules
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.creators.createJournalEntry
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.creators.createLocalization
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.creators.createOverwriteLocalization
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.creators.createScriptValues
import org.victoria_3_syncretic_cultures_creator.diaspora_project.parsers.parseLanguageGroupList
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.logic.calculateCompatibleCultures
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.logic.createMutuallyExclusiveCulturesMap
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.models.SyncreticCulture
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.parsers.getSyncreticCultureConfiguration
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.utils.createGitHubTableForGameRule
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.utils.createGitHubTableFromCulturesConfiguration
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.utils.createModifyHomelandsList
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.utils.sortAlphabetically

fun main() {

    createDiasporaCultures()

    var syncreticCultureConfiguration = sortAlphabetically(getSyncreticCultureConfiguration())

    Exception("Some BS")

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
    //currently chinese has a custom so this serves as an override
    copyManualLocalization()
    copyStaticDecisions()
    copyStaticEvents()


    //optional section

    //Use this if you want a table representation for steam
    //createSteamTableFromCulturesConfiguration(syncreticCultureConfiguration)

    //Use this if you want a table representation for github / for example the readme table
    createGitHubTableFromCulturesConfiguration(syncreticCultureConfiguration)

    //Use this to print a table for the immersive culture game rule setting
    createGitHubTableForGameRule(syncreticCultureConfiguration)

    //Use this to create a list for the syncretic cultures for the modify homelands mod
    createModifyHomelandsList(syncreticCultureConfiguration)

    println("Done")
}
