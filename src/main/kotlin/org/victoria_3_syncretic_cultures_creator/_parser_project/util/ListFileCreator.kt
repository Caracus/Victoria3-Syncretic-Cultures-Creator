package org.victoria_3_syncretic_cultures_creator._parser_project.util

fun createListFile(modPath: String, filePath: String, entries: Set<String>) {

    writeFile("$modPath/$filePath", entries.joinToString("\n\n"))
}