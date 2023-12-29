package org.victoria_3_syncretic_cultures_creator.creators

import org.victoria_3_syncretic_cultures_creator.models.SyncreticCulture
import org.victoria_3_syncretic_cultures_creator.utils.calculateAddonChanceNotTakeBlock
import org.victoria_3_syncretic_cultures_creator.utils.calculateAddonChanceTakeBlock
import org.victoria_3_syncretic_cultures_creator.utils.printFile
import org.victoria_3_syncretic_cultures_creator.utils.readFileAsText

    fun createAddonCultureEvents(syncreticCulture: SyncreticCulture) {
        val textOfFile = readFileAsText("src/main/resources/templates/GenericCultureAddonEventTemplate.txt")

        syncreticCulture.optionalCultures.forEach { optionalCulture ->
            var text = textOfFile

            text = text.replace("<syncretic_culture_name>", syncreticCulture.syncreticCultureName)
            text = text.replace("<addon_culture_name>", optionalCulture)
            text = text.replace("<take_addon_culture_chance>", calculateAddonChanceTakeBlock(optionalCulture, syncreticCulture))
            text = text.replace("<not_take_addon_culture_chance>", calculateAddonChanceNotTakeBlock(optionalCulture, syncreticCulture))

                printFile("events/", "standardize_" + syncreticCulture.syncreticCultureName + "_addon_" + optionalCulture+ ".txt", text)
        }
    }
