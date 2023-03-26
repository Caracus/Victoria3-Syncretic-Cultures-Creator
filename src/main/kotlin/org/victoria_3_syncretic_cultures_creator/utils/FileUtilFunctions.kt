package org.victoria_3_syncretic_cultures_creator.utils

import java.io.File

//prints the created file-s in the target folder
fun printFile(path: String, fileName: String, content: String) {
    val repoPath = "target/generated-mod-files/"
    val savePath = repoPath.plus(path)
    val directory = File(savePath)
    if (directory.mkdirs()) {
        println("Created new folder structure under target")
    }

    //utf with bom
    File(savePath.plus(fileName)).writeText("\uFEFF" + content, Charsets.UTF_8)
}

fun printFileWithoutBom(path: String, fileName: String, content: String) {
    val repoPath = "target/generated-mod-files/"
    val savePath = repoPath.plus(path)
    val directory = File(savePath)
    if (directory.mkdirs()) {
        println("Created new folder structure under target")
    }

    File(savePath.plus(fileName)).writeText(content, Charsets.UTF_8)
}

fun readFileAsText(fileName: String): String = File(fileName).readText(Charsets.UTF_8)