package org.victoria_3_syncretic_cultures_creator._parser_project.parser

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ValueParserTest {

    @Test
    fun `get single value`() {
        val inputText = """
            key1 = value1
            key2 = value2
            key3 = value3
        """.trimIndent()

        val result = parseValue(inputText, "key2")

        assertEquals(KeyValuePair("key2", "value2", false), result)
    }

    @Test
    fun `get complex value`() {
        val inputText = """
            key1 = value1
            key2 = {
                someNestedKey = someNestedValue
            }
            key3 = value3
        """.trimIndent()

        val result = parseValue(inputText, "key2")

        assertEquals(
            KeyValuePair("key2", "someNestedKey = someNestedValue", true),
            result
        )
    }

}