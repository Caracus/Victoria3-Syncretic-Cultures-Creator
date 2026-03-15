package org.victoria_3_syncretic_cultures_creator.diaspora_project.creators

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CultureLookUpBlockCreatorTest {

    @Test
    fun `should create desired look up block`() {
        val information = listOf(
            CultureLookUpInformation("african", "german", "african_german"),
            CultureLookUpInformation("african", "french", "african_french"),
            CultureLookUpInformation("asian", "german", "asian_german"),
        )

        val expectedResult = """
#african
if = {
    limit = {
        shares_heritage_trait_group_with_culture = cu:african_german
    }
    if = {
        limit = {
            cu:african_german = {
                shares_language_trait_group_with_culture = scope:primary_culture
            }
        }
        cu:african_german = {
            save_scope_as = target_diaspora_culture
        }
    }
    else_if = {
        limit = {
            cu:african_french = {
                shares_language_trait_group_with_culture = scope:primary_culture
            }
        }
        cu:african_french = {
            save_scope_as = target_diaspora_culture
        }
    }
}
#asian
else_if = {
    limit = {
        shares_heritage_trait_group_with_culture = cu:asian_german
    }
    if = {
        limit = {
            cu:asian_german = {
                shares_language_trait_group_with_culture = scope:primary_culture
            }
        }
        cu:asian_german = {
            save_scope_as = target_diaspora_culture
        }
    }
}
        """.trimIndent()

        val result = cultureLookUpBlock(information)

        assertEquals(expectedResult, result
        )
    }
}