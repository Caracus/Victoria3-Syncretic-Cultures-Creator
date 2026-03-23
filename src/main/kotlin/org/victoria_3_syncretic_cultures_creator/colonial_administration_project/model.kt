package org.victoria_3_syncretic_cultures_creator.colonial_administration_project

data class ColonialAdminConfig(
    val geographicalRegion: String,
    val regions: List<Region>
)

data class Region(
    val name: String
)