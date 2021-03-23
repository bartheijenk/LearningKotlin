package h5

fun main() {
//    println(greatest(1, 2))
//    println(greatest("deze string is het langst", "deze niet"))
//    println(greatest(1, 2, 3, 4, 5, 6, 7, 8, 9, 0))
//
//    println(factorial(25.0))
//
    val fibo = Fibo()
//    fibo.run(6)
//    fibo.run(6, 4)
//    fibo.run(6, f1 = 4, f2 = 5)
//
//    println(fibo.run(6))
//
//    for (i in 90L..94L) {
//        println("Golden ratio ($i):")
//        println(fibo.goldenRatio(i))
//    }

//    omdat de sequence oneindig is vraag ik de eerste 10 waarden op
    for(i in 0..10) {
        println(fibo.fibonacciYield().iterator().next())
    }
    println(fibo.fibonacciYield().take(10).toList())
}

fun greatest(a: Int, b: Int): Int {
    if (a > b)
        return a
    return b
}

fun greatest(a: String, b: String): String {
    if (a.length > b.length)
        return a
    return b
}

fun greatest(vararg int: Int): Int {
    return int.max()!!
}

fun factorial(inp: Double): Double {
    if (inp > 1) {
        return inp * factorial(inp - 1)
    } else {
        return inp * 1
    }
}