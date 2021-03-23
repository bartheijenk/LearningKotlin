package h4

import java.util.*

fun main() {

    val inp = Scanner(System.`in`)
    elevenProofOne(inp.next())
    println()
    println(warmAndCold(inp.next()))
}

fun elevenProofOne(next: String?) {
    if (next != null) {
        val splitString = next.toCharArray().filter { it != '.' }
        var amount = splitString.size
        var total = 0
        for (char in splitString) {
            total += amount * Character.getNumericValue(char)
            amount--
        }

        if (total % 11 != 0) {
            throw IllegalArgumentException("Not eleven proof")
        }

    }
}

fun warmAndCold(next: String?): Temp {
    return when (next) {
        "Summer" -> Temp.WARM
        "Spring" -> Temp.WARM
        "Fall" -> Temp.COLD
        "Winter" -> Temp.COLD
        else -> {
            Temp.UKNOWN
        }
    }
}
