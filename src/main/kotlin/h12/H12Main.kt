package h12

import h10.Person
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.functions
import kotlin.reflect.full.hasAnnotation

@ExperimentalStdlibApi
fun main() {
    val test = Person::class
    test.functions.stream().filter{ it.annotations.isNotEmpty() }.
    forEach {
        if(it.findAnnotation<MyAnnotation2>() != null)
            println(it.findAnnotation<MyAnnotation2>()?.value)
        if (it.findAnnotation<MyAnnotation2>() != null)
            println(it.findAnnotation<MyAnnotation2>()?.value)
    }
//    println(annotation?.annotationClass?.simpleName)


}