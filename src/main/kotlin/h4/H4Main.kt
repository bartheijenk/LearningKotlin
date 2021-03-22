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
    when (next) {
        "Summer" -> return Temp.WARM
        "Spring" -> return Temp.WARM
        "Fall" -> return Temp.COLD
        "Winter" -> return Temp.COLD
        else -> {
            return Temp.UKNOWN
        }
    }
}
