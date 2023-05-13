package org.victoria_3_syncretic_cultures_creator.parsers

import com.fasterxml.jackson.module.kotlin.jsonMapper
import com.fasterxml.jackson.module.kotlin.kotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import org.victoria_3_syncretic_cultures_creator.models.SyncreticCulture
import java.io.File

fun getSyncreticCultureConfiguration(): List<SyncreticCulture> {
    val mapper = jsonMapper {
        addModule(kotlinModule())
    }
    val text = File("src/main/resources/configuration/SyncreticCulturesConfiguration.json").readText(Charsets.UTF_8)

    val userListFromJson: List<SyncreticCulture> = mapper.readValue(text)

    return userListFromJson

}
