package org.victoria_3_syncretic_cultures_creator.diaspora_project.creators

import org.victoria_3_syncretic_cultures_creator._parser_project.util.LocalizationCreator
import org.victoria_3_syncretic_cultures_creator._parser_project.util.Placeholder
import org.victoria_3_syncretic_cultures_creator._parser_project.util.ResourceReader.justRead
import org.victoria_3_syncretic_cultures_creator._parser_project.util.ResourceReader.readAndRemoveComments
import org.victoria_3_syncretic_cultures_creator._parser_project.util.normalize
import org.victoria_3_syncretic_cultures_creator._parser_project.util.resolvePlaceholders
import org.victoria_3_syncretic_cultures_creator._parser_project.util.writeFile
import org.victoria_3_syncretic_cultures_creator.diaspora_project.parsers.parseLanguageGroupList

fun createDiasporaCultures() {

    val localizationCreator = LocalizationCreator()

    val languageGroups =
        parseLanguageGroupList(readAndRemoveComments("gameFiles/common/discrimination_trait_groups/01_language_groups.txt"))

    val generalPlaceholders = listOf(
        Placeholder("diaspora_color", "rgb{ 233 207 84 }"),
    )

    val configuration = listOf(
        DiasporaCultureConfiguration(
            cultureTemplate = "african",
            placeholders = listOf(
                Placeholder("diaspora_obsession", ""),
                Placeholder("diaspora_traditions", ""),
                Placeholder("diaspora_religion", "catholic")
            )
        ),
        DiasporaCultureConfiguration(
            cultureTemplate = "central_asian",
            placeholders = listOf(
                Placeholder("diaspora_obsession", ""),
                Placeholder("diaspora_traditions", ""),
                Placeholder("diaspora_religion", "catholic")
            )
        ),
        DiasporaCultureConfiguration(
            cultureTemplate = "east_asian",
            placeholders = listOf(
                Placeholder("diaspora_obsession", ""),
                Placeholder("diaspora_traditions", ""),
                Placeholder("diaspora_religion", "catholic")
            )
        ),
        DiasporaCultureConfiguration(
            cultureTemplate = "european",
            placeholders = listOf(
                Placeholder("diaspora_obsession", ""),
                Placeholder("diaspora_traditions", ""),
                Placeholder("diaspora_religion", "catholic")
            )
        ),
        DiasporaCultureConfiguration(
            cultureTemplate = "indigenous_american",
            placeholders = listOf(
                Placeholder("diaspora_obsession", ""),
                Placeholder("diaspora_traditions", ""),
                Placeholder("diaspora_religion", "catholic")
            )
        ),
        DiasporaCultureConfiguration(
            cultureTemplate = "indigenous_oceanic",
            placeholders = listOf(
                Placeholder("diaspora_obsession", ""),
                Placeholder("diaspora_traditions", ""),
                Placeholder("diaspora_religion", "catholic")
            )
        ),
        DiasporaCultureConfiguration(
            cultureTemplate = "middle_eastern",
            placeholders = listOf(
                Placeholder("diaspora_obsession", ""),
                Placeholder("diaspora_traditions", ""),
                Placeholder("diaspora_religion", "catholic")
            )
        ),
        DiasporaCultureConfiguration(
            cultureTemplate = "north_asian",
            placeholders = listOf(
                Placeholder("diaspora_obsession", ""),
                Placeholder("diaspora_traditions", ""),
                Placeholder("diaspora_religion", "catholic")
            )
        ),
        DiasporaCultureConfiguration(
            cultureTemplate = "south_asian",
            placeholders = listOf(
                Placeholder("diaspora_obsession", ""),
                Placeholder("diaspora_traditions", ""),
                Placeholder("diaspora_religion", "catholic")
            )
        ),
        DiasporaCultureConfiguration(
            cultureTemplate = "southeast_asian",
            placeholders = listOf(
                Placeholder("diaspora_obsession", ""),
                Placeholder("diaspora_traditions", ""),
                Placeholder("diaspora_religion", "catholic")
            )
        )
    )

    val cultures = mutableListOf<String>()
    val languageTraits = mutableListOf<String>()
    val heritageTraits = mutableSetOf<String>()

    val mutableCultureLookUpInformationSet = mutableSetOf<CultureLookUpInformation>()

    languageGroups.forEach { languageGroup ->
        // we are distilling top level language down into sub groups
        // vanilla has language as prefix so we should be fine, language_group_ prefix is cut
        val languageTraitKey = "${languageGroup.languageGroupKey.replace("language_group_", "")}_language_family"
        val languageTrait = createTraitEntry(
            localizationCreator,
            type = "language",
            traitKey = languageTraitKey,
            traitGroupKey = languageGroup.languageGroupKey
        )
        languageTraits.add(languageTrait)

        configuration.forEach { configuration ->
            // we are distilling top level heritage down into sub groups
            // vanilla has heritage as prefix so this should be fine for compatibility
            val heritageTraitKey = "${configuration.cultureTemplate}_heritage"
            // traitGroupKey must match vanilla highest level group
            val heritageTrait =
                createTraitEntry(
                    localizationCreator,
                    type = "heritage",
                    traitKey = heritageTraitKey,
                    traitGroupKey = "heritage_group_${configuration.cultureTemplate}"
                )
            heritageTraits.add(heritageTrait)

            val diasporaCultureKey = "${heritageTraitKey}_$languageTraitKey"
            val diasporaCultureName = "${heritageTraitKey}_diaspora".replace("_heritage", "")
                .replace("_language_family", "")

            val specificPlaceholders = listOf(
                Placeholder("diaspora_language_group_heritage_group_key", diasporaCultureKey),
                Placeholder("diaspora_heritage", heritageTraitKey),
                Placeholder("diaspora_language", languageTraitKey),
            )

            localizationCreator.pushLocalization(key = diasporaCultureKey, value = diasporaCultureName.normalize())

            val combinedPlaceholders = generalPlaceholders + specificPlaceholders + configuration.placeholders
            val template = readAndRemoveComments("templates/diaspora_cultures/${configuration.cultureTemplate}.txt")

            val culture = template.resolvePlaceholders(template, combinedPlaceholders)
            cultures.add(culture)

            mutableCultureLookUpInformationSet.add(
                CultureLookUpInformation(heritageTraitKey, languageTraitKey, diasporaCultureKey)
            )
        }
    }

    val diasporaCultureEventTemplate = justRead("templates/diasporaEvent.txt")
    val diasporaCultureEventCultureSelectionBlock = cultureLookUpBlock(mutableCultureLookUpInformationSet.toList())
    val diasporaCultureEventText = diasporaCultureEventTemplate.resolvePlaceholders(
        diasporaCultureEventTemplate,
        listOf(Placeholder("target_culture_block", diasporaCultureEventCultureSelectionBlock))
    )
    writeFile("events/diaspora_culture_selection.txt", diasporaCultureEventText)

    writeFile("common/cultures/99_diaspora_cultures.txt", cultures.joinToString("\n\n"))
    writeFile(
        "common/discrimination_traits/99_diaspora_language_discrimination.txt",
        languageTraits.joinToString("\n\n")
    )
    writeFile(
        "common/discrimination_traits/99_diaspora_heritage_discrimination.txt",
        heritageTraits.joinToString("\n\n")
    )

    localizationCreator.pushLocalization("rule_diaspora_cultures", "Diaspora Change Rate")
    localizationCreator.pushLocalization("setting_diaspora_rate_full", "100%")
    localizationCreator.pushLocalization(
        "setting_diaspora_rate_full_desc",
        "With this setting ALL eligible pops will be converted to Diaspora cultures. This will speed up your game compared to vanilla. They will retain their heritage but adapt to the language family of the primary culture of the country they are in. Any rule will ignore pops in homelands or primary culture pops."
    )
    localizationCreator.pushLocalization("setting_diaspora_rate_medium", "25%")
    localizationCreator.pushLocalization(
        "setting_diaspora_rate_medium_desc",
        "Less than 100% may slow down your game compared to vanilla but is also more immersive. Cultural communities will also stick around as long as in vanilla this way as the yearly reset will affect em fully."
    )
    localizationCreator.pushLocalization("setting_diaspora_rate_low", "5%")
    localizationCreator.pushLocalization(
        "setting_diaspora_rate_low_desc",
        "Less than 100% may slow down your game compared to vanilla but is also more immersive. Cultural communities will also stick around as long as in vanilla this way as the yearly reset will not affect em fully."
    )
    localizationCreator.createLocalizationFiles()
}

data class DiasporaCultureConfiguration(
    val cultureTemplate: String,
    val placeholders: List<Placeholder> = emptyList()
)