package h13generics

class MyIntCollection<T : Int> {
    fun add(t: T) {
        if (size >= array.size)
            array = doubleArray(array)
        array[size] = t
        size++
    }

    fun printArray(): String {
        val s = array.contentToString()
        println(s)
        return s
    }

    fun addAll(vararg t: T) {
        t.forEach { add(it) }
    }

    var size: Int = 0
        private set

    private var array = IntArray(4)

    private fun doubleArray(array: IntArray): IntArray {
        val doubledSize = array.size * 2
        val copy = IntArray(doubledSize)

        array.copyInto(copy)
        return copy
    }


}