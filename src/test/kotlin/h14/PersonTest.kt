package h14

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PersonTest {
    private val person = Person("Jan", 12)

    @Test
    fun iteratorTest() {
        person.addHistory("This")
        person.addHistory("Is")
        person.addHistory("A")
        person.addHistory("Test")
        person.addHistory("You know?")

        for (hr : Person.HistoryRecord in person){
            println(hr)
        }
    }
}