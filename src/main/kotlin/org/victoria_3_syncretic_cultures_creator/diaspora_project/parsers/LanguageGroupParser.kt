package org.victoria_3_syncretic_cultures_creator.diaspora_project.parsers

import org.victoria_3_syncretic_cultures_creator._parser_project.parser.parseMap
import org.victoria_3_syncretic_cultures_creator._parser_project.parser.parseValue

fun parseLanguageGroupList(inputText: String): List<ParsedLanguageGroup> {
    return parseMap(inputText).map { (key, value) ->
        ParsedLanguageGroup(
            languageGroupKey = key,
            languageGroupType = parseValue(value, "type").value
        )
    }
}

data class ParsedLanguageGroup(
    val languageGroupKey : String,
    val languageGroupType: String
)