package org.victoria_3_syncretic_cultures_creator.diaspora_project.creators

import org.victoria_3_syncretic_cultures_creator._parser_project.util.Placeholder
import org.victoria_3_syncretic_cultures_creator._parser_project.util.resolvePlaceholders

fun cultureLookUpBlock(cultureLookUpInformation: List<CultureLookUpInformation>) : String {

    val heritageBaseBlock = """
#<heritage>
<keyword> = {
    limit = {
        shares_heritage_trait_group_with_culture = cu:<culture>
    }
<languageCheckBlock>
}
    """.trimIndent()

    val languageBaseBlock = """
<keyword> = {
    limit = {
        cu:<culture> = {
            shares_language_trait_group_with_culture = scope:primary_culture
        }
    }
    cu:<culture> = {
        save_scope_as = target_diaspora_culture
    }
}
    """.trimIndent()

    val byHeritage: Map<String, List<CultureLookUpInformation>> = cultureLookUpInformation.groupBy { it.heritageTrait }

    val heritageBlocks = mutableListOf<String>()

    byHeritage.values.forEachIndexed { heritageIndex, heritageSection ->

        val languageBlocks = mutableListOf<String>()

        heritageSection.forEachIndexed { langIndex, info ->

            val cultureName = info.cultureName

            languageBlocks.add(
                languageBaseBlock.resolvePlaceholders(
                    languageBaseBlock,
                    listOf(
                        Placeholder("keyword", if (langIndex == 0) "if" else "else_if"),
                        Placeholder("culture", cultureName)
                    )
                )
            )
        }
        val languageCheckBlock = languageBlocks.joinToString("\n")
            .lines()
            .joinToString("\n") { "    $it" }

        // as all entries should have the same heritage here we can just take that
        val heritageBlock = heritageBaseBlock.resolvePlaceholders(
            heritageBaseBlock,
            listOf(
                Placeholder("keyword", if (heritageIndex == 0) "if" else "else_if"),
                Placeholder("heritage", heritageSection.first().heritageTrait),
                Placeholder("culture", heritageSection.first().cultureName),
                Placeholder("languageCheckBlock", languageCheckBlock)
            )
        )
        heritageBlocks.add(heritageBlock)
    }

    val finishedBlock = heritageBlocks.joinToString("\n")

    return finishedBlock
}

data class CultureLookUpInformation(
    val heritageTrait: String, val languageTrait: String, val cultureName: String
)