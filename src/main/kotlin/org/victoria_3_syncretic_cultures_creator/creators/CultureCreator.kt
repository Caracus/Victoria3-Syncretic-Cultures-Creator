package org.victoria_3_syncretic_cultures_creator.creators

import org.victoria_3_syncretic_cultures_creator.models.SyncreticCulture
import org.victoria_3_syncretic_cultures_creator.utils.printFile
import org.victoria_3_syncretic_cultures_creator.utils.readFileAsText

fun createCulture(syncreticCulture: SyncreticCulture) {
    val textOfFile = readFileAsText("src/main/resources/templates/GenericCultureTemplate.txt")

    var text = textOfFile

    text = text.replace("<syncretic_culture_name>", syncreticCulture.syncreticCultureName)
    text = text.replace("<color>", syncreticCulture.color)
    text = text.replace("<religion>", syncreticCulture.religion)
    text = text.replace("<traits>", syncreticCulture.traits)
    text = text.replace("<obsessions>", syncreticCulture.obsessions)
    text = text.replace("<graphics>", syncreticCulture.graphics)
    text = text.replace("<ethnicity>", syncreticCulture.ethnicity)

    text = text.replace("<name_lists>", readFileAsText("src/main/resources/z_name_lists/${syncreticCulture.syncreticCultureName}.txt"))

    printFile("common/cultures/", "" + syncreticCulture.syncreticCultureName + ".txt", text)
}

