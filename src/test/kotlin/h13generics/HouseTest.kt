package h13generics

import h10.Android
import h10.Human
import h10.Person
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class HouseTest {
    private val house = House<Human>(Person("Piet", 10))

    @Test
    fun toStringTest() {
        val expected = "This house is owned by [Piet (10) is UNKNOWN] and it says [Hello, my name is " +
                "Piet. Nice to meet you!]."

        assertEquals(expected, house.toString())

    }
}