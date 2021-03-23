package h5

class Fibo {

    fun run(length: Long, start: Long = 0, f1: Long = 0, f2: Long = 1): Long {
        var outputString = ""

        val s: Long = if (f1 == 0L && f2 == 1L) {
            start
        } else {
            f1
        }
        var outputInt: Long = -1
        for (i in s until s + length) {
            outputInt = tailFib(i, f1, f2)
            outputString += "$outputInt "
        }

        println(outputString)
        return outputInt
    }

    private fun fib(curNumb: Long, f1: Long = 0, f2: Long = 1): Long {
        return when {
            curNumb < f2 -> f1
            curNumb == f2 -> f2
            else -> fib(curNumb - 1, f1, f2) + fib(curNumb - 2, f1, f2)
        }
    }

    private fun tailFib(n: Long, a: Long = 0, b: Long = 1): Long {
        return when (n) {
            0L -> a
            1L -> b
            else -> tailFib(n - 1, b, a + b)
        }
    }

    fun goldenRatio(int: Long): Double {
        return tailFib(int).toDouble() / tailFib(int - 1).toDouble()
    }

    //    opdracht uit H6
    fun runArray(n: Long): LongArray {
        val array = LongArray(n.toInt())
        for (i in 0 until n) {
            array[i.toInt()] = tailFib(i)
        }
        return array
    }

    //    yield test
    fun fibonacciYield() = sequence {
//    Pair zijn twee variabelen die bij elkaar horen
//    Pair werkt beter omdat de assignment tegelijk gebeurd, dus wat 3 ints nodig heeft wordt nu in 2 gedaan
        var terms = Pair(0, 1)

        var a = 0
        var b = 1
        var c = 1

//    The fibonnaci loop
        while (true) {
//        Hier returned hij wat hij momenteel heeft

//        yield(a)
            yield(terms.first)

//        Hier berekent hij de volgende fibbonaci term
            b += a
            a = c
            c = b

            terms = Pair(terms.second, terms.first + terms.second)
        }
//    Deze loop blijft oneindig doorgaan!!!
    }


}


