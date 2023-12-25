package org.victoria_3_syncretic_cultures_creator.creators

import org.victoria_3_syncretic_cultures_creator.models.FormabilityCriteria
import org.victoria_3_syncretic_cultures_creator.models.SyncreticCulture
import org.victoria_3_syncretic_cultures_creator.utils.*

fun createDecision(syncreticCulture: SyncreticCulture) {
        val textOfFile = readFileAsText("src/main/resources/templates/GenericDecisionTemplate.txt")
        var text = textOfFile

        text = text.replace("<syncretic_culture_name>", syncreticCulture.syncreticCultureName)
        text = text.replace("<shown_to_cultures>", createHasPrimaryCulture(2, syncreticCulture.baseCultures, FormabilityCriteria.ANY))
        text = text.replace("<possible_for_cultures>", createHasPrimaryCulture(2, syncreticCulture.baseCultures,FormabilityCriteria.ANY))
        text = text.replace("<optional_addon_cultures_block>", createOptionalCulturesTriggerEventsBlock(2, syncreticCulture.syncreticCultureName ,syncreticCulture.optionalCultures))
        text = text.replace("<exclusive_with_cultures_block>", createExclusiveWithCulturesBlock(2, syncreticCulture.mutuallyExclusiveWith))
        text = text.replace("<exclude_this_decision_block>", createExclusiveWithCulturesBlock(2, setOf(syncreticCulture.syncreticCultureName)))
        text = text.replace("<valid_with_game_rules_block>", createValidWithGameRulesBlock(2,syncreticCulture.defaultCulture, syncreticCulture.syncreticCultureName))

        printFile("/common/decisions/", "standardize_" + syncreticCulture.syncreticCultureName + ".txt", text)
    }
