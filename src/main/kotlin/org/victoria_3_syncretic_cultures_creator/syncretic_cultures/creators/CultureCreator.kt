package org.victoria_3_syncretic_cultures_creator.syncretic_cultures.creators

import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.models.SyncreticCulture
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.utils.printFile
import org.victoria_3_syncretic_cultures_creator.syncretic_cultures.utils.readFileAsText

fun createCulture(syncreticCulture: SyncreticCulture) {
    val textOfFile = readFileAsText("src/main/resources/templates/GenericCultureTemplate.txt")

    var text = textOfFile

    text = text.replace("<syncretic_culture_name>", syncreticCulture.syncreticCultureName)
    text = text.replace("<color>", syncreticCulture.color)
    text = text.replace("<religion>", syncreticCulture.religion)
    text = text.replace("<obsessions>", syncreticCulture.obsessions)
    text = text.replace("<graphics>", syncreticCulture.graphics)
    text = text.replace("<ethnicity>", syncreticCulture.ethnicity)
    text = text.replace("<heritage>", syncreticCulture.heritage ?: "${syncreticCulture.heritageGroup}_heritage")
    text = text.replace("<language>", syncreticCulture.language ?: "${syncreticCulture.syncreticCultureName}_syncretic_language")
    text = text.replace("<traditions>", syncreticCulture.traditions.joinToString(" "))

    text = text.replace("<name_lists>", readFileAsText("src/main/resources/z_name_lists/${syncreticCulture.syncreticCultureName}.txt"))

    printFile("common/cultures/", "" + syncreticCulture.syncreticCultureName + ".txt", text)
}
