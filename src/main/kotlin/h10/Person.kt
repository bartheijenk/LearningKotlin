package h10

import h12.MyAnnotation
import h12.MyAnnotation2
import h7.Gender
import h7.PersonDiedException

open class Person(
    val name: String,
    age: Int,
    var gender: Gender = Gender.UNKNOWN
) : Human() {
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

    init {
        this.age = age
    }

    @MyAnnotation2
    fun haveBirthday() {
        age++
    }

    @MyAnnotation
    override fun greet(): String {
        return "Hello, my name is $name. Nice to meet you!"
    }

    //    Generated equals, very interesting
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


}


