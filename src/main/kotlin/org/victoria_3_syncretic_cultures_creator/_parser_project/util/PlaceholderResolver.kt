package org.victoria_3_syncretic_cultures_creator._parser_project.util

fun String.resolvePlaceholders(text: String, placeholders: List<Placeholder>): String {
    return placeholders.fold(text) { acc, placeholder ->
        acc.replace("<${placeholder.key}>", placeholder.value)
    }
}

data class Placeholder(val key: String, val value: String)