package org.victoria_3_syncretic_cultures_creator.syncretic_cultures.creators

import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.models.FormabilityCriteria
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.models.SyncreticCulture
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.utils.createDecisionCheckOverwriteBlock
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.utils.createExclusiveWithCulturesBlock
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.utils.createHasPrimaryCulture
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.utils.createOptionalCulturesTriggerEventsBlock
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.utils.createPossibleTagsBlock
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.utils.createValidWithGameRulesBlock
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.utils.format
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.utils.printFile
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.utils.readFileAsText

fun createDecision(syncreticCulture: SyncreticCulture) {
        val textOfFile = readFileAsText("src/main/resources/templates/GenericDecisionTemplate.txt")
        var text = textOfFile

        text = text.replace("<syncretic_culture_name>", syncreticCulture.syncreticCultureName)
        text = text.replace("<optional_addon_cultures_block>",
                createOptionalCulturesTriggerEventsBlock(
                        2,
                        syncreticCulture.syncreticCultureName,
                        syncreticCulture.optionalCultures
                )
        )
        text = text.replace("<exclusive_with_cultures_block>",
                createExclusiveWithCulturesBlock(2, syncreticCulture.mutuallyExclusiveWith)
        )
        text = text.replace("<exclude_this_decision_block>",
                createExclusiveWithCulturesBlock(2, setOf(syncreticCulture.syncreticCultureName))
        )
        text = text.replace("<valid_with_game_rules_block>",
                createValidWithGameRulesBlock(2, syncreticCulture.defaultCulture, syncreticCulture.syncreticCultureName)
        )
        text = text.replace("<possible_for_tags>", createPossibleTagsBlock(2, syncreticCulture.tagLimits))

        when (syncreticCulture.journalCheckOverwrite) {
                null -> {
                        text = text.replace("<trait_check_block>", format(0, "", 0))
                        text = text.replace("<shown_to_cultures>",
                                createHasPrimaryCulture(2, syncreticCulture.baseCultures, FormabilityCriteria.ANY)
                        )
                }
                else -> {
                        text = text.replace("<trait_check_block>",
                                createDecisionCheckOverwriteBlock(2, syncreticCulture.journalCheckOverwrite)
                        )
                        text = text.replace("<shown_to_cultures>", format(0, "", 0))
                }
        }

        printFile("/common/decisions/", "standardize_" + syncreticCulture.syncreticCultureName + ".txt", text)
    }

fun copyStaticDecisions(){
        val textOfFile = readFileAsText("src/main/resources/templates/ActualDecisions.txt")
        printFile("/common/decisions/", "syncretic_cultures_base_decisions.txt", textOfFile)
}
