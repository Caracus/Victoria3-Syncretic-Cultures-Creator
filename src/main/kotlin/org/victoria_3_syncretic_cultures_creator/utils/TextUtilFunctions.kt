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

fun convertSnakeCaseToLocalizedString(snakeString: String): String {
    var combinedString = ""
    snakeString.split("_").forEach {
        combinedString += it.capitalize() + " "
    }
    return combinedString.trimEnd()
}

fun printSetInHumanReadableForm(genericSet: Set<String>): String {
    if(genericSet.isEmpty()){
        return ""
    }
    if(genericSet.size == 1){
        return convertSnakeCaseToLocalizedString(genericSet.first())
    }

    var combinedString = ""
    combinedString += convertSnakeCaseToLocalizedString(genericSet.first())
    genericSet.toList().drop(1).dropLast(1).forEach {
        combinedString += ", ${convertSnakeCaseToLocalizedString(it)}"
    }
    combinedString += " and ${convertSnakeCaseToLocalizedString(genericSet.last())}"
    return combinedString
}

fun printSetWithoutBrackets(genericSet: Set<String>): String {
    return genericSet.toString().replace("[","").replace("]","").trim()
}
