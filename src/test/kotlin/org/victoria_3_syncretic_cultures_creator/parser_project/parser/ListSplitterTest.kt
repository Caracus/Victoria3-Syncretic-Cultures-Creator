package org.victoria_3_syncretic_cultures_creator.parser_project.parser

import org.junit.Test
import kotlin.test.assertEquals

class ListSplitterTest {

    @Test
    fun `split well formed list`() {
        // Arrange
        val listSplitter = ListSplitter()

        val inputText = """
            language_group_algic = {
                type = language
            }
    
            language_group_albanic = {
                type = language
            }
    
            language_group_armenian = {
                type = language
            }
        """.trimIndent()

        // Act
        val result = listSplitter.splitList(inputText)

        // Assert
        assertEquals(3, result.size)
        assertEquals(
            """
            language_group_algic = {
                type = language
            }
            """.trimIndent(),
            result[0]
        )
        assertEquals(
            """
            language_group_albanic = {
                type = language
            }
            """.trimIndent(),
            result[1]
        )
        assertEquals(
            """
            language_group_armenian = {
                type = language
            }
            """.trimIndent(),
            result[2]
        )
    }

    @Test
    fun `split chaotic list`() {
        // Arrange
        val listSplitter = ListSplitter()

        val inputText = """
            language_group_algic = {
                type = language}
    
            language_group_albanic = {
                type = language
            }
            language_group_armenian = {
                type = language
            }
        """.trimIndent()

        // Act
        val result = listSplitter.splitList(inputText)

        // Assert
        assertEquals(3, result.size)
        assertEquals(
            """
            language_group_algic = {
                type = language}
            """.trimIndent(),
            result[0]
        )
        assertEquals(
            """
            language_group_albanic = {
                type = language
            }
            """.trimIndent(),
            result[1]
        )
        assertEquals(
            """
            language_group_armenian = {
                type = language
            }
            """.trimIndent(),
            result[2]
        )
    }

    @Test
    fun `nested list`() {
        // Arrange
        val listSplitter = ListSplitter()

        val inputText = """
            someKey = {
                anotherKey = {
                    value = something
                }
            }
    
            someDifferentKey = {
                anotherDifferentKey = {
                    value = somethingDifferent
                }
            }
        """.trimIndent()

        // Act
        val result = listSplitter.splitList(inputText)

        // Assert
        assertEquals(2, result.size)
        assertEquals(
            """
            someKey = {
                anotherKey = {
                    value = something
                }
            }
            """.trimIndent(),
            result[0]
        )
        assertEquals(
            """
            someDifferentKey = {
                anotherDifferentKey = {
                    value = somethingDifferent
                }
            }
            """.trimIndent(),
            result[1]
        )
    }
}