package org.victoria_3_syncretic_cultures_creator.diaspora_project.creators

import org.victoria_3_syncretic_cultures_creator._parser_project.util.Placeholder
import org.victoria_3_syncretic_cultures_creator._parser_project.util.resolvePlaceholders
import org.victoria_3_syncretic_cultures_creator._parser_project.util.writeFile

fun cultureLookUpBlock(cultureLookUpInformation: List<CultureLookUpInformation>) {

    val heritageBaseBlock = """
#<heritage>
if = {
    limit = {
        shares_heritage_trait_group_with_culture = cu:<culture>
    }
    if = {
        <languageCheckBlock>
    }
}
    """.trimIndent()

    val languageBaseBlock = """
if = {
    limit = {
        shares_language_trait_with_culture = cu:<culture>
    }
    cu:<culture> = {
        save_scope_as = scope:target_diaspora_culture
    }
}
    """.trimIndent()

    val byHeritage: Map<String, List<CultureLookUpInformation>> = cultureLookUpInformation.groupBy { it.heritageTrait }

    val heritageBlocks = mutableListOf<String>()

    byHeritage.forEach { heritage ->

        val languageBlocks = mutableListOf<String>()

        heritage.value.forEach {

            val cultureName = it.cultureName

            languageBlocks.add(
                languageBaseBlock.resolvePlaceholders(
                    languageBaseBlock,
                    listOf(Placeholder("culture", cultureName))
                )
            )
        }
        val languageCheckBlock = languageBlocks.joinToString("\n")

        val heritageBlock = heritageBaseBlock.resolvePlaceholders(
            heritageBaseBlock,
            listOf(
                Placeholder("heritage", heritage.value[thisIteration].heritageTrait),
                Placeholder("culture", heritage.value[thisIteration].cultureName)),
                Placeholder("languageCheckBlock", languageCheckBlock),
            )
        )
    }

    val finishedBlock = heritageBlocks.joinToString("\n")

    writeFile("test.txt", finishedBlock)
}


data class CultureLookUpInformation(
    val heritageTrait: String, val languageTrait: String, val cultureName: String
)