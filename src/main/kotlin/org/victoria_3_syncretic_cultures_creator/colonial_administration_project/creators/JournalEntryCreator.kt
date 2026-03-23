package org.victoria_3_syncretic_cultures_creator.colonial_administration_project.creators

import org.victoria_3_syncretic_cultures_creator._parser_project.util.Placeholder
import org.victoria_3_syncretic_cultures_creator._parser_project.util.ResourceReader.justRead
import org.victoria_3_syncretic_cultures_creator._parser_project.util.resolvePlaceholders
import org.victoria_3_syncretic_cultures_creator._parser_project.util.writeFile
import org.victoria_3_syncretic_cultures_creator.colonial_administration_project.ColonialAdminConfig
import org.victoria_3_syncretic_cultures_creator.colonial_administration_project.Region

fun createJournalEntryTemplate(colonialAdminConfig: ColonialAdminConfig) {
    val template = justRead("templates/colonial_administrations/journal_entry_template.txt")

    val updatedTemplate = template.resolvePlaceholders(
        template,
        listOf(
            Placeholder("geographic_region", colonialAdminConfig.geographicalRegion),
            Placeholder(
                "interest_marker_in_region_block",
                createJournalEntryInterestMarkerBlock(colonialAdminConfig.regions)
            ),
            Placeholder("state_region_scoping_block", createScopingBlock(colonialAdminConfig.regions)),
            Placeholder("found_button_block", createFoundingButtonBlock(colonialAdminConfig.regions)),
            Placeholder("expand_button_block", createExpandingButtonBlock(colonialAdminConfig.regions)),
        )
    )

    writeFile(
        "colonialAdminMod/common/journal_entries/00_establish_colonial_administration_${colonialAdminConfig.geographicalRegion}.txt",
        updatedTemplate
    )
}

fun createJournalEntryInterestMarkerBlock(regions: List<Region>): String {
    val block = regions.joinToString("\n") { region ->
        "has_interest_marker_in_region = sr:region_${region.name}"
    }

    return block
}

fun createScopingBlock(regions: List<Region>): String {
    val block = regions.joinToString("\n") { region ->
        """
            random_state_region = {
                limit = {
                    region = sr:region_${region.name}
                }
                save_scope_as = ${region.name}_region_scope
            }
        """.trimIndent()
    }

    return block
}

fun createFoundingButtonBlock(regions: List<Region>): String {
    val block = regions.joinToString("\n") { region ->
        "scripted_button = je_colonial_administration_mod_button_${region.name}"
    }

    return block
}

fun createExpandingButtonBlock(regions: List<Region>): String {
    val block = regions.joinToString("\n") { region ->
        "scripted_button = je_colonial_administration_mod_button_expand_${region.name}"
    }

    return block
}