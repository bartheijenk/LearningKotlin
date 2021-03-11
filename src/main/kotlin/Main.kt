import java.util.*

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        while (true) {
            hoi = scanner.nextLine()


            println(hoi)
        }
    }

    var hoi: String = ""
        get() = "Hallo $field"
        private set
}