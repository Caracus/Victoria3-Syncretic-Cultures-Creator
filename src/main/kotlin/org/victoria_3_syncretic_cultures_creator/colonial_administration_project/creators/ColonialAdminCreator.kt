package org.victoria_3_syncretic_cultures_creator.colonial_administration_project.creators

import org.victoria_3_syncretic_cultures_creator._parser_project.util.LocalizationCreator
import org.victoria_3_syncretic_cultures_creator._parser_project.util.normalize
import org.victoria_3_syncretic_cultures_creator._parser_project.util.writeFile
import org.victoria_3_syncretic_cultures_creator.colonial_administration_project.ColonialAdminConfig
import org.victoria_3_syncretic_cultures_creator.colonial_administration_project.Region

fun createColonialAdmins() {
    val colonialAdminConfigs = listOf(
        ColonialAdminConfig(
            geographicalRegion = "europe",
            regions = listOf(
                Region("north_germany"),
                Region("south_germany"),
                Region("england"),
                Region("iberia"),
                Region("france"),
                Region("occitania"),
                Region("rhine"),
                Region("italy"),
                Region("poland"),
                Region("danubia"),
                Region("balkans"),
                Region("baltic"),
                Region("russia"),
                Region("dnieper"),
                Region("belarus"),
                Region("finland"),
                Region("baltic_states"),
                Region("north_sea_coast"),
            )
        ),
        ColonialAdminConfig(
            geographicalRegion = "africa",
            regions = listOf(
                Region("nile_basin"),
                Region("ethiopia"),
                Region("north_africa"),
                Region("senegal"),
                Region("niger"),
                Region("congo"),
                Region("southern_africa"),
                Region("zanj"),
            )
        ),
        ColonialAdminConfig(
            geographicalRegion = "north_america",
            regions = listOf(
                Region("canada"),
                Region("new_england"),
                Region("pacific_coast"),
                Region("great_plains"),
                Region("the_midwest"),
                Region("dixie"),
            )
        ),
        ColonialAdminConfig(
            geographicalRegion = "central_america",
            regions = listOf(
                Region("mexico"),
                Region("central_america"),
                Region("caribbean"),
            )
        ),
        ColonialAdminConfig(
            geographicalRegion = "south_america",
            regions = listOf(
                Region("brazil"),
                Region("la_plata"),
                Region("andes"),
                Region("gran_colombia"),
            )
        ),
        ColonialAdminConfig(
            geographicalRegion = "middle_east",
            regions = listOf(
                Region("anatolia"),
                Region("arabic"),
                Region("persia"),
                Region("caucasus"),
            )
        ),
        ColonialAdminConfig(
            geographicalRegion = "central_asia",
            regions = listOf(
                Region("himalayas"),
                Region("central_asia"),
            )
        ),
        ColonialAdminConfig(
            geographicalRegion = "india",
            regions = listOf(
                Region("punjab"),
                Region("bombay"),
                Region("central_india"),
                Region("madras"),
                Region("bengal"),
            )
        ),
        ColonialAdminConfig(
            geographicalRegion = "south_east_asia",
            regions = listOf(
                Region("indonesia"),
                Region("indochina"),
            )
        ),
        ColonialAdminConfig(
            geographicalRegion = "east_asia",
            regions = listOf(
                Region("south_china"),
                Region("north_china"),
                Region("manchuria"),
                Region("japan"),
                Region("west_siberia"),
                Region("east_siberia"),
            )
        )
    )

    val localizationCreator = LocalizationCreator("colonialAdminMod")

    val buttonList: MutableList<String> = mutableListOf()

    colonialAdminConfigs.forEach { colonialAdminConfig ->
        createJournalEntryTemplate(colonialAdminConfig)

        colonialAdminConfig.regions.forEach { region ->
            localizationCreator.pushLocalization(
                key = "je_colonial_administration_mod_${colonialAdminConfig.geographicalRegion}",
                value = "Colonial Administration: ${colonialAdminConfig.geographicalRegion.normalize()}"
            )
            localizationCreator.pushLocalization(
                key = "je_colonial_administration_mod_${colonialAdminConfig.geographicalRegion}_reason",
                value = "In order to best leverage our rule over our holdings, a #bold Colonial Administration#! may be established over a region here. These new entities will be the instrument of our control and expansion in this corner of the world. Be it to spread our religion, build a new home for our people, or enrich ourselves with foreign riches — whether the known or the unknown. These lands await us.#!"
            )
            localizationCreator.pushLocalization(
                key = "je_colonial_administration_mod_button_${region.name}",
                value = "Establish Colony in [SCOPE.sStateRegion('${region.name}_region_scope').GetStrategicRegion.GetName]"
            )
            localizationCreator.pushLocalization(
                key = "je_colonial_administration_mod_button_${region.name}_desc",
                value = "A colony will be established in [SCOPE.sStateRegion('${region.name}_region_scope').GetStrategicRegion.GetName]"
            )
            localizationCreator.pushLocalization(
                key = "je_colonial_administration_mod_button_expand_${region.name}",
                value = "Expand our colony in [SCOPE.sStateRegion('${region.name}_region_scope').GetStrategicRegion.GetName]"
            )
            localizationCreator.pushLocalization(
                key = "je_colonial_administration_mod_button_expand_${region.name}_desc",
                value = "Expand our colony in [SCOPE.sStateRegion('${region.name}_region_scope').GetStrategicRegion.GetName]"
            )

            val button =
                createColonialAdminButtons(colonialAdminConfig.geographicalRegion, region)

            buttonList.add(button)
        }
    }

    localizationCreator.createLocalizationFiles("colonial_administration_expanded")
    writeFile(
        "colonialAdminMod/common/scripted_buttons/00_colonial_administration_buttons.txt",
        buttonList.joinToString("\n\n")
    )
}