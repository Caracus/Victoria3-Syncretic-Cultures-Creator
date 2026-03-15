package org.victoria_3_syncretic_cultures_creator.diaspora_project.creators

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CultureLookUpBlockCreatorTest {

    @Test
    fun `should create desired look up block`() {
        val information = listOf(
            CultureLookUpInformation("african", "german", "african_german"),
            CultureLookUpInformation("african", "french", "african_french"),
            CultureLookUpInformation("asian", "german", "african_german"),
        )

        val expectedResult = """
#african
if = {
    limit = {
        shares_heritage_trait_group_with_culture = cu:african_german
    }
    if = {
        limit = {
            shares_language_trait_with_culture = cu:african_german
        }
        cu:african_german = {
            save_scope_as = scope:target_diaspora_culture
        }
    }
    if = {
        limit = {
            shares_language_trait_with_culture = cu:african_french
        }
        cu:african_french = {
            save_scope_as = scope:target_diaspora_culture
        }
    }
}
#asian
if = {
    limit = {
        shares_heritage_trait_group_with_culture = cu:african_german
    }
    if = {
        limit = {
            shares_language_trait_with_culture = cu:african_german
        }
        cu:african_german = {
            save_scope_as = scope:target_diaspora_culture
        }
    }
}
        """.trimIndent()

        val result = cultureLookUpBlock(information)

        assertEquals(expectedResult, result
        )
    }
}