package h3

object H3Main {

    @JvmStatic
    fun main(args: Array<String>) {
        testplusplusOne()

        println("\n2:")

        println(calcJTwo(3))

        println("\n3: ")

        println(binAddThree())

        println("\n4:")

        println(calc80HoursFour())

        println("\n5:")

        println(refTypeTestFive())


    }

    private fun refTypeTestFive(): String {
        println("Assumption is client1.name = Joris")
        var client1 = Client("Jan")
        var client2 = Client("Piet")
        client2 = client1
        client2.name = "Joris"


        return "Name of client2: ${client2.name} \nName of client1: ${client1.name} "

    }

    data class Client(var name: String)

    private fun calc80HoursFour(): String {
        var currenthour = 23
        val amountHours = 80

        currenthour = (currenthour + amountHours) % 24

        return "The current hour is: $currenthour"
    }


    private fun binAddThree(): Int {
        return 0b1010 + 0b100
    }

    fun calcJTwo(input: Int) : Int {
        var i = input
        val j = if (i < 3) i++ + ++i else ++i ushr 1
        return j
    }

    fun testplusplusOne() {
        var test = 0

        println("dit is test++: " + test++)
        println("dit is ++test: " + ++test)
    }
}
