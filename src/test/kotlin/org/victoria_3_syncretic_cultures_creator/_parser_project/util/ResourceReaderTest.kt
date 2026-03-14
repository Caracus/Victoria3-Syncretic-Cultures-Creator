package org.victoria_3_syncretic_cultures_creator._parser_project.util

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ResourceReaderTest {

    @Test
    fun `reads file content from resources`() {
        val content = ResourceReader.readAndRemoveComments("test_resource.txt").trim()
        assertEquals("hello from resource file", content)
    }
}
