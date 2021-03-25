package h11

import h10.Human
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


internal class PersonTest {
    private var person: Person
    init {
        person = Person("Henk", 25)
    }


    @Test
    fun addHistoryTest() {
        val description = "Hi!"

        person.addHistory(description)

        assertEquals(description, person.historyRecord[0].toString())
    }

    @Test
    fun printHistoryTest() {
        val expectedList = listOf("Hi!", "this", "Is", "A test")
        val expectedString = expectedList.joinToString(separator = "\n")

        expectedList.forEach { person.addHistory(it) }

        assertEquals(expectedString, person.printHistory())

    }

    @Test
    fun createSubHumanTest() {
        val subHuman : Human = person.createSubHuman()

        assertEquals("Sub is the best.", subHuman.greet())
    }
}