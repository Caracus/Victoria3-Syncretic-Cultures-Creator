package org.victoria_3_syncretic_cultures_creator.diaspora_project.creators

import org.victoria_3_syncretic_cultures_creator._parser_project.util.Placeholder
import org.victoria_3_syncretic_cultures_creator._parser_project.util.ResourceReader.readAndRemoveComments
import org.victoria_3_syncretic_cultures_creator._parser_project.util.addLocalization
import org.victoria_3_syncretic_cultures_creator._parser_project.util.normalize
import org.victoria_3_syncretic_cultures_creator._parser_project.util.resolvePlaceholders
import org.victoria_3_syncretic_cultures_creator._parser_project.util.writeFile
import org.victoria_3_syncretic_cultures_creator.diaspora_project.parsers.parseLanguageGroupList

fun createDiasporaCultures() {

    val languageGroups =
        parseLanguageGroupList(readAndRemoveComments("gameFiles/common/discrimination_trait_groups/01_language_groups.txt"))

    val generalPlaceholders = listOf(
        Placeholder("<diaspora_color>", "rgb{ 233 207 84 }"),
    )

    val configuration = listOf(
        DiasporaCultureConfiguration(
            cultureTemplate = "african",
            placeholders = listOf(
                Placeholder("<diaspora_obsession>", ""),
                Placeholder("<diaspora_traditions>", ""),
                Placeholder("diaspora_religion", "catholic")
            )
        ),
        DiasporaCultureConfiguration(
            cultureTemplate = "central_asian",
            placeholders = listOf(
                Placeholder("<diaspora_obsession>", ""),
                Placeholder("<diaspora_traditions>", ""),
                Placeholder("diaspora_religion", "catholic")
            )
        ),
        DiasporaCultureConfiguration(
            cultureTemplate = "east_asian",
            placeholders = listOf(
                Placeholder("<diaspora_obsession>", ""),
                Placeholder("<diaspora_traditions>", ""),
                Placeholder("diaspora_religion", "catholic")
            )
        ),
        DiasporaCultureConfiguration(
            cultureTemplate = "european",
            placeholders = listOf(
                Placeholder("<diaspora_obsession>", ""),
                Placeholder("<diaspora_traditions>", ""),
                Placeholder("diaspora_religion", "catholic")
            )
        ),
        DiasporaCultureConfiguration(
            cultureTemplate = "indigenous_american",
            placeholders = listOf(
                Placeholder("<diaspora_obsession>", ""),
                Placeholder("<diaspora_traditions>", ""),
                Placeholder("diaspora_religion", "catholic")
            )
        ),
        DiasporaCultureConfiguration(
            cultureTemplate = "indigenous_oceanic",
            placeholders = listOf(
                Placeholder("<diaspora_obsession>", ""),
                Placeholder("<diaspora_traditions>", ""),
                Placeholder("diaspora_religion", "catholic")
            )
        ),
        DiasporaCultureConfiguration(
            cultureTemplate = "middle_eastern",
            placeholders = listOf(
                Placeholder("<diaspora_obsession>", ""),
                Placeholder("<diaspora_traditions>", ""),
                Placeholder("diaspora_religion", "catholic")
            )
        ),
        DiasporaCultureConfiguration(
            cultureTemplate = "north_asian",
            placeholders = listOf(
                Placeholder("<diaspora_obsession>", ""),
                Placeholder("<diaspora_traditions>", ""),
                Placeholder("diaspora_religion", "catholic")
            )
        ),
        DiasporaCultureConfiguration(
            cultureTemplate = "south_asian",
            placeholders = listOf(
                Placeholder("<diaspora_obsession>", ""),
                Placeholder("<diaspora_traditions>", ""),
                Placeholder("diaspora_religion", "catholic")
            )
        ),
        DiasporaCultureConfiguration(
            cultureTemplate = "southeast_asian",
            placeholders = listOf(
                Placeholder("<diaspora_obsession>", ""),
                Placeholder("<diaspora_traditions>", ""),
                Placeholder("diaspora_religion", "catholic")
            )
        )
    )

    val cultures = mutableListOf<String>()
    val languageTraits = mutableListOf<String>()
    val heritageTraits = mutableListOf<String>()

    languageGroups.forEach { languageGroup ->
        val languageTraitKey = "${languageGroup.languageGroupKey}_family_trait"
        val languageTrait = createTraitEntry("language", languageTraitKey, languageGroup.languageGroupKey)
        languageTraits.add(languageTrait)

        configuration.forEach { configuration ->
            val heritageTraitKey = "${languageGroup.languageGroupKey}_diaspora"
            val heritageTrait =
                createTraitEntry("heritage", "${languageGroup.languageGroupKey}_diaspora", configuration.cultureTemplate)
            heritageTraits.add(heritageTrait)

            val diasporaCultureKey = heritageTraitKey + " " + languageTraitKey

            val specificPlaceholders = listOf(
                Placeholder("<<diaspora_language_group_heritage_group_key>={>", diasporaCultureKey),
                Placeholder("<diaspora_heritage>", heritageTraitKey),
                Placeholder("<diaspora_language>", languageTraitKey),
            )

            addLocalization(key = diasporaCultureKey, value = "diasporaCultureKey".normalize())

            val combinedPlaceholders = generalPlaceholders + specificPlaceholders + configuration.placeholders
            val template = readAndRemoveComments("templates/diaspora_cultures/${configuration.cultureTemplate}.txt")

            val culture = template.resolvePlaceholders(template, combinedPlaceholders)
            cultures.add(culture)
        }
    }

    writeFile("common/cultures/99_diaspora_cultures.txt", cultures.joinToString("\n\n"))
    writeFile("common/discrimination_trait_groups/99_diaspora_language_discrimination.txt", languageTraits.joinToString("\n\n"))
    writeFile("common/discrimination_trait_groups/99_diaspora_heritage_discrimination.txt", heritageTraits.joinToString("\n\n"))
}

data class DiasporaCultureConfiguration(
    val cultureTemplate: String,
    val placeholders: List<Placeholder> = emptyList()
)