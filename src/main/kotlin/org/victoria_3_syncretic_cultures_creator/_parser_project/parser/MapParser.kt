package org.victoria_3_syncretic_cultures_creator._parser_project.parser

fun parseMap(text: String): Map<String, String> {
    val result = mutableMapOf<String, String>()
    var depth = 0
    var entryStart = -1
    var braceOpen = -1

    for (i in text.indices) {
        val ch = text[i]
        when {
            ch == '{' -> {
                if (depth == 0) braceOpen = i
                if (depth == 0 && entryStart == -1) entryStart = i
                depth++
            }
            ch == '}' -> {
                depth--
                if (depth == 0 && entryStart != -1 && braceOpen != -1) {
                    val key = text.substring(entryStart, braceOpen).replace("=", "").trim()
                    val value = text.substring(braceOpen + 1, i).trimIndent()
                    result[key] = value
                    entryStart = -1
                    braceOpen = -1
                }
            }
            depth == 0 && !ch.isWhitespace() && entryStart == -1 -> {
                entryStart = i
            }
        }
    }

    return result
}
