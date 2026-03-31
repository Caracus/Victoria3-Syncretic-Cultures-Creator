package org.victoria_3_syncretic_cultures_creator._parser_project.util

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PlaceholderResolverTest {

    @Test
    fun `resolve placeholders`() {
        val someValue = "someText"
        val anotherValue = "anotherText"

        val inputText = """
            lalala
            <some_key>
            lorem ipsum
            <some_key>
            
            <another_key>
            done
        """.trimIndent()

        val result = inputText.resolvePlaceholders(
            inputText,
            listOf(
                Placeholder("some_key", someValue),
                Placeholder("another_key", anotherValue)
            )
        )

        assertEquals(
            """
            lalala
            $someValue
            lorem ipsum
            $someValue
            
            $anotherValue
            done
        """.trimIndent(), result
        )
    }
}