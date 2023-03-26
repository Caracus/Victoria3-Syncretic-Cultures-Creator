package org.victoria_3_syncretic_cultures_creator.utils

//even tho the game engine does not need formatting it is here to prevent eye cancer
fun format(indentations: Int, text: String, linebreaks: Int): String {
    var txt = ""
    for (i in 0 until indentations) {
        txt = txt.plus("\t")
    }
    txt = txt.plus(text)
    for (i in 0 until linebreaks) {
        txt = txt.plus("\n")
    }
    return txt
}

fun convertSnakeCaseToLocalizedString(snakeString: String): String{
    var combinedString = ""
    snakeString.split("_").forEach {
        combinedString+= it.capitalize() + " "
    }
    return combinedString.trimEnd()
}