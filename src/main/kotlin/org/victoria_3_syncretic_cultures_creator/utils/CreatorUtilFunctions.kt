package org.victoria_3_syncretic_cultures_creator.utils

import org.victoria_3_syncretic_cultures_creator.models.FormabilityCriteria
import org.victoria_3_syncretic_cultures_creator.models.SyncreticCulture

fun createHasPrimaryCulture(indentations: Int, baseCultures: Set<String>, logicalOperator: FormabilityCriteria): String {
    var text = ""
    when (logicalOperator) {
        FormabilityCriteria.ALL -> {
            baseCultures.forEach {
                text += format(indentations, "country_has_primary_culture = cu:$it", 1)
            }
        }
        FormabilityCriteria.ANY -> {
            text += format(2, "OR = {", 1)
            baseCultures.forEach {
                text += format(indentations+1, "country_has_primary_culture = cu:$it", 1)
            }
            text += format(2, "}", 1)
        }
    }
    return text
}

fun createOptionalCulturesTriggerEventsBlock(indentations: Int, syncreticCulture: String, optionalCultures: Set<String>) : String{
    var text = ""
    optionalCultures.forEach {
        text += format(indentations,"trigger_event = { id = standardize_${syncreticCulture}_addon_$it.1 }" ,1)
    }
    return text
}

fun createExclusiveWithCulturesBlock(indentations: Int, exclusiveCultures: Set<String>) : String{
    var text = ""
    exclusiveCultures.forEach { exlusiveCulture ->
        text += format(indentations,"custom_tooltip = {" ,1)
        text += format(indentations+1,"text = standardize_${exlusiveCulture}_decision_not_var_custom_tooltip" ,1)
        text += format(indentations+1,"NOT = {" ,1)
        text += format(indentations+2,"has_variable = standardize_${exlusiveCulture}_decision_var" ,1)
        text += format(indentations+1,"}" ,1)
        text += format(indentations,"}" ,1)
    }
    return text
}

fun createValidWithGameRulesBlock(indentations: Int, validWithGameRules: Boolean, syncreticCulture: String) : String{
    var text = ""

    if(validWithGameRules){
        text += format(indentations, "OR = { has_game_rule = setting_sc_${syncreticCulture}_auto is_player = yes AND = { has_game_rule = immersive_syncretic_cultures_allowed NOT = { has_game_rule = setting_sc_${syncreticCulture}_never }} }",1)
    } else {
        text += format(indentations, "OR = { has_game_rule = setting_sc_${syncreticCulture}_auto is_player = yes }",1)
    }

    return text
}

fun createBaseCulturesHomelandCheckBlock(indentations: Int, baseCultures: Set<String>) : String{
    var text = ""
    baseCultures.forEach { baseCulture ->
        text += format(indentations,"cu:$baseCulture =  {" ,1)
        text += format(indentations+1,"has_homeland = PREV" ,1)
        text += format(indentations,"}" ,1)
    }
    return text
}

fun createOptionalCulturesHomelandCheckBlock(indentations: Int, syncreticCulture: String, optionalCultures: Set<String>) : String{
    var text = ""
    optionalCultures.forEach { optionalCulture ->
        text += format(indentations,"AND = {" ,1)
        text += format(indentations+1,"ROOT = {" ,1)
        text += format(indentations+2,"has_variable = standardize_${syncreticCulture}_addon_${optionalCulture}_var" ,1)
        text += format(indentations+1,"}" ,1)
        text += format(indentations+1,"cu:$optionalCulture = {" ,1)
        text += format(indentations+2,"has_homeland = PREV" ,1)
        text += format(indentations+1,"}" ,1)
        text += format(indentations,"}" ,1)
    }
    return text
}

fun createRemovePrimaryBaseCulturesBlock(indentations: Int, baseCultures: Set<String>) : String{
    var text = ""
    baseCultures.forEach { baseCulture ->
        text += format(indentations,"remove_primary_culture = cu:$baseCulture" ,1)
    }
    return text
}

fun createRemovePrimaryAddonCulturesBlock(indentations: Int, syncreticCulture: String, optionalCultures: Set<String>) : String{
    var text = ""
    optionalCultures.forEach { optionalCulture ->
        text += format(indentations,"if = {" ,1)
        text += format(indentations+1,"limit = {" ,1)
        text += format(indentations+2,"ROOT = {" ,1)
        text += format(indentations+3,"has_variable = standardize_${syncreticCulture}_addon_${optionalCulture}_var" ,1)
        text += format(indentations+2,"}" ,1)
        text += format(indentations+1,"}" ,1)
        text += format(indentations+1,"remove_primary_culture = cu:$optionalCulture" ,1)
        text += format(indentations,"}" ,1)
    }
    return text
}

fun createRemoveBaseCultureHomelandsBlock(indentations: Int, baseCultures: Set<String>) : String{
    var text = ""
    baseCultures.forEach { baseCulture ->
        text += format(indentations,"remove_homeland = cu:$baseCulture" ,1)
    }
    return text
}

fun createRemoveAddonCultureHomelandsBlock(indentations: Int, syncreticCulture: String, optionalCultures: Set<String>) : String{
    var text = ""
    optionalCultures.forEach { optionalCulture ->
        text += format(indentations,"if = {" ,1)
        text += format(indentations+1,"limit = {" ,1)
        text += format(indentations+2,"ROOT = {" ,1)
        text += format(indentations+3,"has_variable = standardize_${syncreticCulture}_addon_${optionalCulture}_var" ,1)
        text += format(indentations+2,"}" ,1)
        text += format(indentations+1,"}" ,1)
        text += format(indentations+1,"remove_homeland = cu:$optionalCulture" ,1)
        text += format(indentations,"}" ,1)
    }
    return text
}

fun createBaseCulturePopCheckBlock(indentations: Int, baseCultures: Set<String>) : String{
    var text = ""
    baseCultures.forEach { baseCulture ->
        text += format(indentations,"has_pop_culture = $baseCulture" ,1)
    }
    return text
}

fun createAddonCulturePopCheckBlock(indentations: Int, syncreticCulture: String, optionalCultures: Set<String>) : String{
    var text = ""
    optionalCultures.forEach { optionalCulture ->
        text += format(indentations,"AND = {" ,1)
        text += format(indentations+1,"ROOT = {" ,1)
        text += format(indentations+2,"has_variable = standardize_${syncreticCulture}_addon_${optionalCulture}_var" ,1)
        text += format(indentations+1,"}" ,1)
        text += format(indentations+1,"has_pop_culture = $optionalCulture" ,1)
        text += format(indentations,"}" ,1)
    }
    return text
}

fun createCompatibleCulturesCheckBlock(indentations: Int, compatibleCultures: Set<String>) : String{
    var text = ""
    compatibleCultures.forEach { compatibleCulture ->
        text += format(indentations,"has_pop_culture = $compatibleCulture" ,1)
    }
    return text
}

fun createGameRuleBlock(indentations: Int, syncreticCultures: List<SyncreticCulture>): String{
    var text = ""
    syncreticCultures.forEach { syncreticCulture ->
        text += format(indentations,"sc_${syncreticCulture.syncreticCultureName} = {" ,1)
        text += format(indentations+1,"default = sc_${syncreticCulture.syncreticCultureName}_manual" ,1)
        text += format(indentations,"" ,1)

        text += format(indentations+1,"sc_${syncreticCulture.syncreticCultureName}_never = {}" ,1)
        text += format(indentations,"" ,1)
        text += format(indentations+1,"sc_${syncreticCulture.syncreticCultureName}_manual = {}" ,1)
        text += format(indentations,"" ,1)
        text += format(indentations+1,"sc_${syncreticCulture.syncreticCultureName}_auto = {}" ,1)
        text += format(indentations,"}" ,1)
        text += format(indentations,"" ,1)
    }
    return text
}



