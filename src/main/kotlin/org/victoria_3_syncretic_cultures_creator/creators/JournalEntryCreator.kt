package org.victoria_3_syncretic_cultures_creator.creators

import org.victoria_3_syncretic_cultures_creator.models.FormabilityCriteria
import org.victoria_3_syncretic_cultures_creator.models.SyncreticCulture
import org.victoria_3_syncretic_cultures_creator.utils.createHasPrimaryCulture
import org.victoria_3_syncretic_cultures_creator.utils.printFile
import org.victoria_3_syncretic_cultures_creator.utils.readFileAsText

    fun createJournalEntry(syncreticCulture: SyncreticCulture) {
        val textOfFile = readFileAsText("src/main/resources/templates/GenericJournalEntryTemplate.txt")
        var text = textOfFile

        text = text.replace("<syncretic_culture_name>", syncreticCulture.syncreticCultureName)
        text = text.replace("<shown_to_cultures>", createHasPrimaryCulture(2, syncreticCulture.baseCultures, FormabilityCriteria.ANY))
        text = text.replace("<possible_for_cultures>", createHasPrimaryCulture(2, syncreticCulture.baseCultures, syncreticCulture.formabilityCriteria))

        printFile("common/journal_entries/", "standardize_" + syncreticCulture.syncreticCultureName + ".txt", text)
    }
