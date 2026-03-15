package org.victoria_3_syncretic_cultures_creator._parser_project.util

class LocalizationCreator {
    private val mutableList = mutableSetOf<String>()

    private val languages: Set<String> = setOf(
        "braz_por", "english", "french", "german", "japanese", "korean", "polish", "russian", "simp_chinese", "spanish", "turkish"
    )

    fun pushLocalization(key: String, value: String) {
        this.mutableList += " $key:0 \"$value\""
    }

    fun createLocalizationFiles() {
        languages.forEach { language ->
            val beginningLine = "l_$language:\n"
            val localization = mutableList.joinToString("\n")
            writeFile("localization/$language/diaspora_system_l_$language.yml", beginningLine + localization, utf8Bom = true)
        }
        println("Created localization files")
    }
}
