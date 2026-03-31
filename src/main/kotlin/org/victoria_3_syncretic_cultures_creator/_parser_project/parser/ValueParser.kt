package org.victoria_3_syncretic_cultures_creator._parser_project.parser

fun parseValue(text: String, searchKey: String): KeyValuePair {
    val keyPattern = Regex("""^\s*${Regex.escape(searchKey)}\s*=""", RegexOption.MULTILINE)
    val match = keyPattern.find(text) ?: throw IllegalArgumentException("Key '$searchKey' not found")

    var i = match.range.last + 1
    while (i < text.length && text[i] == ' ') i++

    return if (text[i] == '{') {
        var depth = 0
        var end = -1
        for (k in i until text.length) {
            when (text[k]) {
                '{' -> depth++
                '}' -> { depth--; if (depth == 0) { end = k; break } }
            }
        }
        KeyValuePair(searchKey, text.substring(i + 1, end).trim(), true)
    } else {
        val end = text.indexOf('\n', i).let { if (it == -1) text.length else it }
        KeyValuePair(searchKey, text.substring(i, end).trim(), false)
    }
}

data class KeyValuePair(val key: String, val value: String, val nested: Boolean)
