package org.victoria_3_syncretic_cultures_creator._parser_project.util

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CommentRemoverTest {

    @Test
    fun `parse single entry`() {
        val inputText = """
            # some fancy comment
            # yay more comments
            
            #more comments
            
            language_group_algic = {#even more comment
                type = language# some other comment devs forgot
            }
            
            # mean trailing comment
        """.trimIndent()

        val result = removeComments(inputText)

        assertEquals("""
            language_group_algic = {
                type = language
            }
        """.trimIndent(), result)
    }
}