package h3

object H3Main {

    @JvmStatic
    fun main(args: Array<String>) {
        testplusplusOne()

        println("\n2:")

        calcJTwo(3)

        println("\n3: ")

        binAddThree()

        println("\n4:")

        calc80HoursFour()

        println("\n5:")

        refTypeTestFive()



    }

    private fun refTypeTestFive() {
        println("Assumption is client1.name = Joris")
        var client1 = Client("Jan")
        var client2 = Client("Piet")
        client2 = client1
        client2.name = "Joris"

        println("Name of client2: ${client2.name} \nName of client1: ${client1.name} ")

    }

    data class Client(var name: String)

    private fun calc80HoursFour() {
        var currenthour = 23
        val amountHours = 80

        currenthour = (currenthour + amountHours) % 24

        println("The current hour is: $currenthour")
    }


    private fun binAddThree() {
        println(0b1010 + 0b100)
    }

    fun calcJTwo(input: Int) {
        var i = input
        val j = if (i < 3) i++ + ++i else ++i ushr 1
        println(j)
    }

    fun testplusplusOne() {
        var test = 0

        println("dit is test++: " + test++)
        println("dit is ++test: " + ++test)
    }
}
