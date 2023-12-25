package org.victoria_3_syncretic_cultures_creator.creators

import org.victoria_3_syncretic_cultures_creator.models.SyncreticCulture
import org.victoria_3_syncretic_cultures_creator.utils.*

fun createCultureEvents(syncreticCulture: SyncreticCulture, compatibleCultures :Set<String>?) {
    val textOfFile = readFileAsText("src/main/resources/templates/GenericCultureEventTemplate.txt")

        var text = textOfFile

        text = text.replace("<syncretic_culture_name>", syncreticCulture.syncreticCultureName)

        text = text.replace("<base_cultures_homeland_check_block>", createBaseCulturesHomelandCheckBlock(7, syncreticCulture.baseCultures))
        text = text.replace("<optional_cultures_homeland_check_block>", createOptionalCulturesHomelandCheckBlock(7, syncreticCulture.syncreticCultureName, syncreticCulture.optionalCultures))

        text = text.replace("<remove_primary_base_cultures_block>", createRemovePrimaryBaseCulturesBlock(2, syncreticCulture.baseCultures))
        text = text.replace("<remove_primary_addon_cultures_block>", createRemovePrimaryAddonCulturesBlock(2, syncreticCulture.syncreticCultureName, syncreticCulture.optionalCultures))

        text = text.replace("<remove_base_cultures_homelands_block>", createRemoveBaseCultureHomelandsBlock(3, syncreticCulture.baseCultures))
        text = text.replace("<remove_addon_cultures_homelands_block>", createRemoveAddonCultureHomelandsBlock(2, syncreticCulture.syncreticCultureName, syncreticCulture.optionalCultures))

        text = text.replace("<base_culture_pop_check_block>", createBaseCulturePopCheckBlock(7, syncreticCulture.baseCultures))
        text = text.replace("<addon_culture_pop_check_block>", createAddonCulturePopCheckBlock(7, syncreticCulture.syncreticCultureName, syncreticCulture.optionalCultures))

        compatibleCultures?.let {
            text = text.replace("<compatible_culture_pop_check_block>", createCompatibleCulturesCheckBlock(7, compatibleCultures))
        }

        printFile("events/", "standardize_" + syncreticCulture.syncreticCultureName + ".txt", text)

}
