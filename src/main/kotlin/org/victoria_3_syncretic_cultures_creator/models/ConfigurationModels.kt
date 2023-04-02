package org.victoria_3_syncretic_cultures_creator.models

data class SyncreticCulture(
    val syncreticCultureName: String,
    val baseCultures: Set<String>,
    val formabilityCriteria: FormabilityCriteria,
    val optionalCultures: Set<String>,
    val defaultCulture: Boolean,
    val mutuallyExclusiveWith: Set<String>,
    val localization: String,
    val color: String,
    val religion: String,
    val traits: String,
    val obsessions: String,
    val graphics: String,
    val ethnicity: String
)

enum class FormabilityCriteria{
    ANY,
    ALL
}
