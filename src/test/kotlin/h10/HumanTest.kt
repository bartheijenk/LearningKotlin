package h10

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class HumanTest {

    @Test
    fun greetTests() {
//        given
        val person = Person("Jan", 25)
        val android = Android()
        val employee = Employee()
        val teacher = Teacher("Bram", 40)

//        when
        android.chargeUp(100)

//        then
        assertEquals("Hello, my name is Jan. Nice to meet you!", person.greet())
        assertEquals("I'm only half human, but human still... My energy level is 90%", android.greet())
        assertEquals("I'm tired of working. This is inhuman!", employee.greet())
        assertEquals("Hello, my name is Bram. Nice to meet you!", teacher.greet())
    }

    @Test
    fun androidTests() {
        val android = Android()

        assertEquals(100, android.chargeUp(200))

        assertEquals(0, android.chargeUp(-3000))
    }
}