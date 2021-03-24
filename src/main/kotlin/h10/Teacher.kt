package h10

import h7.Gender

class Teacher(
    name: String,
    age: Int,
    gender: Gender = Gender.UNKNOWN
) : Person(
    name, age, gender
){
}
