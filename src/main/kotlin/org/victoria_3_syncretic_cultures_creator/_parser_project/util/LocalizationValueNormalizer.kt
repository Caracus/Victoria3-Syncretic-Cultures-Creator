package org.victoria_3_syncretic_cultures_creator._parser_project.util

fun String.normalize(): String {
    return this.trim()
        .replace('_', ' ')
        .split(' ')
        .filter { it.isNotEmpty() }
        .joinToString(" ") { word -> word.replaceFirstChar { it.uppercaseChar() } }
}