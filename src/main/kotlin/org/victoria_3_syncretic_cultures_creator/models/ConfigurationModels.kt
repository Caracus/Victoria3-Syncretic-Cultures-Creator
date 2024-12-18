package org.victoria_3_syncretic_cultures_creator.models

data class SyncreticCulture(
    val syncreticCultureName: String,
    val baseCultures: Set<String>,
    val formabilityCriteria: FormabilityCriteria,
    val tagLimits: Set<String>,
    val optionalCultures: Set<String>,
    val defaultCulture: Boolean,
    val optionalsUsedByAi: Set<String>,
    val mutuallyExclusiveWith: Set<String>,
    val localization: String,
    val color: String,
    val religion: String,
    val traits: String,
    val obsessions: String,
    val graphics: String,
    val ethnicity: String,
    val journalCheckOverwrite: String?
)

enum class FormabilityCriteria{
    ANY,
    ALL
}
