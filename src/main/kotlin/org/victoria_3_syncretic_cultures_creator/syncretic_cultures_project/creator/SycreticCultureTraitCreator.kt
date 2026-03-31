package org.victoria_3_syncretic_cultures_creator.syncretic_cultures_project.creator

import org.victoria_3_syncretic_cultures_creator._parser_project.util.LocalizationCreator
import org.victoria_3_syncretic_cultures_creator._parser_project.util.createListFile
import org.victoria_3_syncretic_cultures_creator._parser_project.util.creators.createTraitEntry
import org.victoria_3_syncretic_cultures_creator._parser_project.util.creators.createTraitGroupEntry

import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.models.SyncreticCulture
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures_project.SYNCRETIC_CULTURES_MOD_FOLDER

fun createSyncreticCultureTraits(syncreticCultures: List<SyncreticCulture>) {

    val localizationCreator = LocalizationCreator(SYNCRETIC_CULTURES_MOD_FOLDER)
    val heritageTraitGroups = mutableSetOf<String>()
    val languageTraitGroups = mutableSetOf<String>()
    val languageTraits = mutableSetOf<String>()
    val heritageTraits = mutableSetOf<String>()

    syncreticCultures.forEach { syncreticCulture ->

        val heritageTraitGroupName = "heritage_group_syncretic_${syncreticCulture.syncreticCultureName}"
        val languageTraitGroupName = "language_group_syncretic_${syncreticCulture.syncreticCultureName}"

        val heritageGroup = createTraitGroupEntry(
            localizationCreator,
            type = "heritage",
            traitGroupName = heritageTraitGroupName,
            traitKeySuffix = syncreticCulture.syncreticCultureName
        )

        val languageGroup = createTraitGroupEntry(
            localizationCreator,
            type = "language",
            traitGroupName = languageTraitGroupName,
            traitKeySuffix = syncreticCulture.syncreticCultureName
        )

        val heritageTrait = createTraitEntry(
            localizationCreator,
            type = "heritage",
            traitKey = "${syncreticCulture.syncreticCultureName}_heritage",
            traitGroupKey = heritageGroup
        )

        val languageTrait = createTraitEntry(
            localizationCreator,
            type = "language",
            traitKey = "${syncreticCulture.syncreticCultureName}_syncretic_language",
            traitGroupKey = languageGroup
        )

        heritageTraitGroups.add(heritageGroup)
        languageTraitGroups.add(languageGroup)
        languageTraits.add(languageTrait)
        heritageTraits.add(heritageTrait)
    }

    createListFile(SYNCRETIC_CULTURES_MOD_FOLDER,"common/discrimination_trait_groups/syncreticLanguageTraitGroups.txt",languageTraitGroups)
    createListFile(SYNCRETIC_CULTURES_MOD_FOLDER,"common/discrimination_trait_groups/syncreticHeritageTraitGroups.txt",heritageTraitGroups)
    createListFile(SYNCRETIC_CULTURES_MOD_FOLDER,"common/discrimination_traits/syncreticLanguageTraits.txt",languageTraits)
    createListFile(SYNCRETIC_CULTURES_MOD_FOLDER,"common/discrimination_traits/syncreticHeritageTraits.txt",heritageTraits)

    localizationCreator.createLocalizationFiles("traitsAndTraitGroups")
}