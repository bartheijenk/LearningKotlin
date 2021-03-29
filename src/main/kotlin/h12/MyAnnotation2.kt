package h12

@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.FUNCTION)
annotation class MyAnnotation2(val value: String = "Hello2") {
}
