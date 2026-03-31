package org.victoria_3_syncretic_cultures_creator._parser_project.util

fun removeComments(input: String): String {
    return input.lines()
        .map { line -> line.substringBefore('#').trimEnd() }
        .filter { it.isNotBlank() }
        .joinToString("\n")
}
