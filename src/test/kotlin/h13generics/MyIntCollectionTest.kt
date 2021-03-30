package h13generics

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MyIntCollectionTest{

    private val myIntCollection = MyIntCollection<Int>()

    @Test
    fun addTest() {
        myIntCollection.add(2)
        myIntCollection.printArray()
        assertEquals(1, myIntCollection.size)
    }

    @Test
    fun `Adding more than four members should double array`() {
        myIntCollection.addAll(1,2,3,4,5,6)
        assertEquals(6, myIntCollection.size)
        assertEquals("[1, 2, 3, 4, 5, 6, 0, 0]", myIntCollection.printArray())
    }
}