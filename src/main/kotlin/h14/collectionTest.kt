package h14

import java.util.*

fun main() {
    val collection = MyCollection<Int>()


    collection.push(1)
    collection.push(2)
    collection.push(3)
    collection.pop()
    collection.push(4)
    collection.push(5)
    collection.push(6)

//    println(collection.pop())
//    println(collection.pop())

    for(i in collection) {
        println(i)
    }
}