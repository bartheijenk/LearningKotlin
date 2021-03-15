package h7

fun main() {
    var p = Person("Jan", 45)
    println(p.gender)
    p.gender = Gender.MALE
    println(p.gender)
    p.haveBirthday()
    println(p.age)
    println(Person.numberOfPossibleGenders)
}