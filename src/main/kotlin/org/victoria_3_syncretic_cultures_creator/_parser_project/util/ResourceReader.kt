package org.victoria_3_syncretic_cultures_creator._parser_project.util

object ResourceReader {
    fun readAndRemoveComments(filePath: String): String {
        val resourcePath = "/$filePath"
        val content = ResourceReader::class.java.getResourceAsStream(resourcePath)?.bufferedReader()?.readText()
            ?: error("Resource not found: $resourcePath")
        return removeComments(content)
    }
}
