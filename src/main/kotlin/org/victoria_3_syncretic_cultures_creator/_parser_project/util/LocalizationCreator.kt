package org.victoria_3_syncretic_cultures_creator._parser_project.util

class LocalizationCreator(private val modFolder: String) {
    private val mutableList = mutableSetOf<String>()

    private val languages: Set<String> = setOf(
        "braz_por", "english", "french", "german", "japanese", "korean", "polish", "russian", "simp_chinese", "spanish", "turkish"
    )

    fun pushLocalization(key: String, value: String) {
        this.mutableList += " $key: \"$value\""
    }

    fun createLocalizationFiles(filePrefix: String) {
        languages.forEach { language ->
            val beginningLine = "l_$language:\n"
            val localization = mutableList.joinToString("\n")
            writeFile("$modFolder/localization/$language/${filePrefix}_l_$language.yml", beginningLine + localization, utf8Bom = true)
        }
        println("Created localization files")
    }
}
