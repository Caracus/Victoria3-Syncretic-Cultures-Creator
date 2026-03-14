package org.victoria_3_syncretic_cultures_creator.diaspora_project

import org.junit.jupiter.api.Test
import org.victoria_3_syncretic_cultures_creator.diaspora_project.parsers.ParsedLanguageGroup
import org.victoria_3_syncretic_cultures_creator.diaspora_project.parsers.parseLanguageGroupList
import kotlin.test.assertEquals

class LanguageGroupParserTest {

    @Test
    fun `get single value`() {
        // real text example excerpt from in game without comment
        val inputText = """
            language_group_ainuic = {
                type = language
            }
            
            language_group_algic = {
                type = language
            }
        """.trimIndent()

        val result = parseLanguageGroupList(inputText)

        assertEquals(
            ParsedLanguageGroup(
                languageGroupKey = "language_group_ainuic",
                languageGroupType = "language"
            ), result[0]
        )

        assertEquals(
            ParsedLanguageGroup(
                languageGroupKey = "language_group_algic",
                languageGroupType = "language"
            ), result[1]
        )
    }
}