package h7

import java.lang.IllegalArgumentException

class Person(
        val name: String,
        age: Int
) {
    companion object {
        var numberOfPossibleGenders : Int = Gender.values().size
        val maxAge = 130
    }
    var gender: Gender = Gender.UNKNOWN

    var age: Int = 0
        set(value) {
            if (value < 0){
                throw IllegalArgumentException("Age must be positive")}
            else if (value > maxAge)
                throw PersonDiedException()
            else
                field = value
        }
    init {
        this.age = age
    }

    fun haveBirthday() {
        if(age <= maxAge)
            age++
        else
            throw PersonDiedException()

    }
}


