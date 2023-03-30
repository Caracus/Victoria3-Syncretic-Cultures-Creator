package org.victoria_3_syncretic_cultures_creator.utils

import org.victoria_3_syncretic_cultures_creator.models.SyncreticCulture

fun createSteamTableFromCulturesConfiguration(syncreticCultureList: List<SyncreticCulture>) {
    println("[table]")
    println("[tr]")
    println("[th]Syncretic Culture[/th]")
    println("[th]Base Cultures[/th]")
    println("[th]Optional Cultures[/th]")
    println("[/tr]")
    syncreticCultureList.forEach {
        println("[tr]")
        println("[th]${it.localization}[/th]")
        println("[th]${it.baseCultures}[/th]")
        println("[th]${it.optionalCultures}[/th]")
        println("[/tr]")
    }
    println("[/table]")
}

fun createGitHubTableFromCulturesConfiguration(syncreticCultureList: List<SyncreticCulture>) {
    println("| Syncretic Culture | Base Cultures | Optional Cultures |")
    println("| ----------------- | ------------- | ----------------- |")
    syncreticCultureList.forEach {
        println("| ${it.localization} | ${printSetInHumanReadableForm(it.baseCultures)} | ${printSetInHumanReadableForm(it.optionalCultures)} |")
    }
}