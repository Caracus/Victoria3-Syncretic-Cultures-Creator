package org.victoria_3_syncretic_cultures_creator.parser_project.parser

class ListSplitter {

    fun splitList(text: String): List<String> {
        val results = mutableListOf<String>()
        var depth = 0
        var entryStart = -1

        for (i in text.indices) {
            val ch = text[i]
            when {
                ch == '{' -> {
                    if (depth == 0) entryStart = if (entryStart == -1) i else entryStart
                    depth++
                }
                ch == '}' -> {
                    depth--
                    if (depth == 0 && entryStart != -1) {
                        results.add(text.substring(entryStart, i + 1).trim())
                        entryStart = -1
                    }
                }
                depth == 0 && !ch.isWhitespace() && entryStart == -1 -> {
                    entryStart = i
                }
            }
        }

        return results
    }
}