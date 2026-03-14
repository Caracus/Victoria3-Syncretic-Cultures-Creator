package org.victoria_3_syncretic_cultures_creator._parser_project.util

import java.io.File

private const val TARGET_FOLDER = "target/generated-mod-files/"

fun writeFile(filePath: String, content: String) {
    val file = File(TARGET_FOLDER + filePath)
    file.parentFile.mkdirs()
    file.writeText(content, Charsets.UTF_8)
    println("Created file under $filePath")
}
