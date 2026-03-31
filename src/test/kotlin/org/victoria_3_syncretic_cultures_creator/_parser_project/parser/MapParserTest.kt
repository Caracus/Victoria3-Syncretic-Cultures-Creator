package org.victoria_3_syncretic_cultures_creator._parser_project.parser

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MapParserTest {

    @Test
    fun `parse single entry`() {
        val inputText = """
            language_group_algic = {
                type = language
            }
        """.trimIndent()

        val result = parseMap(inputText)

        assertEquals(1, result.size)
        assertEquals("type = language", result["language_group_algic"])
    }

    @Test
    fun `parse multiple entries`() {
        val inputText = """
            language_group_algic = {
                type = language
            }

            language_group_albanic = {
                type = language
            }
        """.trimIndent()

        val result = parseMap(inputText)

        assertEquals(2, result.size)
        assertEquals("type = language", result["language_group_algic"])
        assertEquals("type = language", result["language_group_albanic"])
    }

    @Test
    fun `parse preserves nested content`() {
        val inputText = """
            someKey = {
                anotherKey = {
                    value = something
                }
            }
        """.trimIndent()

        val result = parseMap(inputText)

        assertEquals(1, result.size)
        assertEquals("""
                anotherKey = {
                    value = something
                }
        """.trimIndent(), result["someKey"])
    }
}
