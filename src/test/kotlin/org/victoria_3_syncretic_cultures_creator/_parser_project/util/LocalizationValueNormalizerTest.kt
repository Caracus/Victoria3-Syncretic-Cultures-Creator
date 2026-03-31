package org.victoria_3_syncretic_cultures_creator._parser_project.util

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LocalizationValueNormalizerTest {

    @Test
    fun `normalize string`() {
        val exampleText = " _some_ugly_string_ "

        val result = removeComments(exampleText).normalize()

        assertEquals(
            "Some Ugly String", result
        )
    }
}