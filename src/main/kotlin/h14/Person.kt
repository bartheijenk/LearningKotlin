package h14

import h10.Human
import h7.Gender
import h7.PersonDiedException
import kotlin.collections.Iterable

open class Person(
    val name: String,
    age: Int,
    var gender: Gender = Gender.UNKNOWN
) : Human(), Iterable<Person.HistoryRecord>
{
    //    static values
    companion object {
        var numberOfPossibleGenders: Int = Gender.values().size
        const val maxAge = 130
    }

    var age: Int = 0
        set(value) {
            when {
                value < 0 -> throw IllegalArgumentException("Age must be positive")
                value > maxAge -> throw PersonDiedException()
                else -> field = value
            }
        }

    val historyRecord = mutableListOf<HistoryRecord>()

    init {
        this.age = age
    }

    fun haveBirthday() {
        age++
    }

    override fun greet() : String {
        return "Hello, my name is $name. Nice to meet you!"
    }


    fun addHistory(desc: String) {
        historyRecord.add(HistoryRecord(desc))
    }

    fun printHistory(): String {
        val result = historyRecord.joinToString("\n")
        println(result)
        return result
    }

    //    Generated equals, very interesting

    fun createSubHuman(): Human {
        return object : Human() {
            override fun greet(): String {
                return "Sub is the best."
            }
        }
    }

    inner class HistoryRecord(
            var desc: String
    ) {
        override fun toString(): String {
            return desc
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person

        if (name != other.name) return false
        if (gender != other.gender) return false
        if (age != other.age) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result *= gender.hashCode()
        result *= age
        return result
    }

    override fun toString(): String {
        return "$name ($age) is $gender"
    }

    override fun iterator(): Iterator<HistoryRecord> {
        return historyRecord.iterator()
    }


}

