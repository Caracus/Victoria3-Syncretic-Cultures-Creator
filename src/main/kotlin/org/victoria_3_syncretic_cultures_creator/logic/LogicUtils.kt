package org.victoria_3_syncretic_cultures_creator.logic

import org.victoria_3_syncretic_cultures_creator.models.SyncreticCulture

fun createMutuallyExclusiveCulturesMap(syncreticCultureList: List<SyncreticCulture>): List<SyncreticCulture> {
    val cultureToSyncreticCultureMap: MutableMap<String, MutableSet<String>> = mutableMapOf()
    val syncreticCultureMutuallyExclusiveMap: MutableMap<String, MutableSet<String>> = mutableMapOf()

    for (syncreticCulture in syncreticCultureList) {
        for (baseCulture in syncreticCulture.baseCultures) {
            val existingSet = cultureToSyncreticCultureMap.getOrPut(baseCulture) { mutableSetOf() }
            existingSet += syncreticCulture.syncreticCultureName
        }
        syncreticCultureMutuallyExclusiveMap[syncreticCulture.syncreticCultureName] = syncreticCulture.mutuallyExclusiveWith.toMutableSet()
    }

    for ((baseCulture, syncreticCultures) in cultureToSyncreticCultureMap) {
        val uniqueSyncreticCultures = syncreticCultures.toSet()
        for (syncreticCultureName in syncreticCultures) {
            val mutuallyExclusiveWith = syncreticCultureMutuallyExclusiveMap[syncreticCultureName]!!
            mutuallyExclusiveWith += uniqueSyncreticCultures - syncreticCultureName
        }
    }

    return syncreticCultureList.map { syncreticCulture ->
        syncreticCulture.copy(mutuallyExclusiveWith = syncreticCultureMutuallyExclusiveMap[syncreticCulture.syncreticCultureName]!!)
    }
}

fun createMutuallyExclusiveCulturesMapOld(syncreticCultureList: List<SyncreticCulture>): List<SyncreticCulture> {
    // create a map that represents which syncretic cultures are using the culture in question
    var cultureToSyncreticCultureMap: MutableMap<String, Set<String>> = mutableMapOf()

    syncreticCultureList.forEach { syncreticCulture ->
        syncreticCulture.baseCultures.forEach { baseCulture ->
            cultureToSyncreticCultureMap[baseCulture]?.let { existingSet ->
                cultureToSyncreticCultureMap.replace(
                    baseCulture,
                    existingSet.plus(syncreticCulture.syncreticCultureName)
                )
            }
                ?: cultureToSyncreticCultureMap.put(baseCulture, setOf(syncreticCulture.syncreticCultureName))

        }
    }

    // use the created map to create the mutually exclusive lists
    val syncreticCultureMutuallyExclusiveMap: MutableMap<String, Set<String>> = mutableMapOf()

    syncreticCultureList.forEach { syncreticCulture ->
        syncreticCultureMutuallyExclusiveMap.put(
            syncreticCulture.syncreticCultureName,
            syncreticCulture.mutuallyExclusiveWith
        )

        syncreticCulture.baseCultures.forEach { baseCulture ->
            cultureToSyncreticCultureMap[baseCulture]!!.forEach { potentialSyncreticCulture ->
                if (potentialSyncreticCulture != syncreticCulture.syncreticCultureName) {
                    syncreticCultureMutuallyExclusiveMap.replace(
                        syncreticCulture.syncreticCultureName,
                        syncreticCultureMutuallyExclusiveMap[syncreticCulture.syncreticCultureName]!!.plus(
                            potentialSyncreticCulture
                        )
                    )
                }
            }
        }
    }

    var updatedSyncreticCultureList: List<SyncreticCulture> = listOf()

    syncreticCultureList.forEach { syncreticCulture ->
        updatedSyncreticCultureList = updatedSyncreticCultureList.plus(syncreticCulture.copy(mutuallyExclusiveWith = syncreticCultureMutuallyExclusiveMap[syncreticCulture.syncreticCultureName]!!))
    }

    return updatedSyncreticCultureList

}
