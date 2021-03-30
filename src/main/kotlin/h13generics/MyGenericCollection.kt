package h13generics

class MyGenericCollection<T> {

    fun add(t: T) {
        if (size >= array.size)
            array = doubleArray(array as Array<*>) as Array<Any?>
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

    private var array = arrayOfNulls<Any>(4)

    private fun doubleArray(array: Array<*>): Array<*> {
        val doubledSize = array.size * 2
        val copy = arrayOfNulls<Any>(doubledSize)

        return array.copyInto(copy)
    }


}