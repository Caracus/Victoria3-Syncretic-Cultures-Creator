package org.victoria_3_syncretic_cultures_creator.colonial_administration_project.creators

import org.victoria_3_syncretic_cultures_creator._parser_project.util.Placeholder
import org.victoria_3_syncretic_cultures_creator._parser_project.util.ResourceReader.justRead
import org.victoria_3_syncretic_cultures_creator._parser_project.util.resolvePlaceholders
import org.victoria_3_syncretic_cultures_creator.colonial_administration_project.Region

fun createColonialAdminButtons(geographicalRegion: String, region: Region): String {
    val template = justRead("templates/colonial_administrations/button_template.txt")

    val updateTemplate = template.resolvePlaceholders(
        template,
        listOf(
            Placeholder("region", region.name),
            Placeholder("geographic_region", geographicalRegion)
        )
    )

    return updateTemplate
}