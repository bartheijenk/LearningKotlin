package h8

import h7.Gender
import h7.PersonDiedException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class PersonTest {
    lateinit var person: Person
    private val initialAge = 25
    private val name = "Jan"
    private val gender = Gender.NONBINARY

    @BeforeEach
    fun setUp() {
        person = Person(name, initialAge)
        person.gender = gender
    }

    @Nested
    inner class SetAgeTests {

        @Test
        fun `Normal setAge usage`() {
            val expectedAge = 12
            person.age = expectedAge

            assertEquals(expectedAge, person.age)
        }

        @Test
        fun `Too old should throw exception`() {
            assertThrows<PersonDiedException> {
                person.age = Person.maxAge + 1
            }
        }

        @Test
        fun `Negative number is not allowed`() {
            assertThrows<IllegalArgumentException> {
                person.age = -2
            }
        }
    }

    @Nested
    inner class HaveBirthdayTests {

        @Test
        fun `normal haveBirthday usage`() {
            val expectedAge = initialAge + 1

            person.haveBirthday()

            assertEquals(expectedAge, person.age)
        }

        @Test
        fun `Age too high, should throw exception`() {
            person.age = Person.maxAge
            assertThrows<PersonDiedException> {
                person.haveBirthday()
            }
        }
    }

    @Test
    fun toStringTest() {
        assertEquals("${name} (${initialAge}) is NONBINARY", person.toString())
    }

    @Test
    fun equalsTest() {
        val person2 = Person(name, initialAge)
        person2.gender = gender

        assertTrue(person == person2)
    }

    @Test
    fun hashcodeTest() {
        val expected = initialAge * name.hashCode() * gender.hashCode()

        assertEquals(expected, person.hashCode())
    }

}