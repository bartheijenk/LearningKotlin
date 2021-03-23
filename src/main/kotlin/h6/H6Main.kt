package h6

import h5.Fibo

fun main() {
//    testArray()

    val array = arrayOf(1L,2L,3L,4L).toLongArray()
    println(doubleArray(array).contentToString())

    println(multiplyArrayBy(array, 3).contentToString())

    println(arrayFib(94L).contentToString())
}

//Opdracht 1 en 2
fun testArray() {
    val row = IntArray(4)
    row[2] = 3
    val copy = row
    copy[2]++

    println(row[2])
//    println(row[4])

}

//Opdracht 3
fun doubleArray(array: LongArray) : LongArray {
    val doubledSize = array.size * 2
    val copy = LongArray(doubledSize)

    array.copyInto(copy)
    return copy

}

//Opdracht 4
fun multiplyArrayBy(array: LongArray, multiplier: Int): LongArray {
    val copy = LongArray(array.size)
    array.forEach {
        copy[array.indexOf(it)] = it * multiplier
    }
    return copy
}

//Opdracht 5
fun arrayFib(n : Long) : LongArray {
    val fib = Fibo()
    return if (n < 94) {
        fib.runArray(n)
    } else {
        fib.runArray(93)
    }
}