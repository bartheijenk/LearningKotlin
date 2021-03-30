package h13generics

import h10.Person
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MyGenericCollectionTest{
    private val myGenericCollection = MyGenericCollection<Person>()

    @Test
    fun addTest() {
        myGenericCollection.add(Person("Piet", 10))
        myGenericCollection.printArray()
    }
}
