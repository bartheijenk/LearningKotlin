package h10.micro

import java.math.BigDecimal

private val list = initList()

fun main() {
    while (true) {
        printCards()
        val card = getCard()
        val amount: Int = getAmount()

        if (card.pay(amount)) {
            println("\nPayment successful!\n")
        } else {
            println("\nPayment unsuccessful, credit remains unchanged\n")
        }

    }
}

private fun getAmount(): Int {
    var amount: Int? = null
    while (amount == null) {
        print("Enter the amount to pay ")
        amount = try {
            readLine()!!.toInt()
        } catch (e: NumberFormatException) {
            println("Not a number")
            null
        }
    }
    return amount
}

private fun getCard(): Card {
    var card: Card? = null
    while (card == null) {
        print("\nEnter the cardID: ")
        val cardId = readLine()!!.toInt()
        card = list.find { it.cardId == cardId }
        if (card == null)
            println("That card does not exist")
        else
            return card
    }
    return card
}

private fun initList(): List<Card> {
    return listOf(
        RegularCard(1235, "Gerda", BigDecimal(1000.0)),
        GoldCard(1236, "Donald", BigDecimal(7000.0), 10),
        RegularCard(1237, "Edward", BigDecimal(5000.0)),
        GoldCard(1238, "Mona", BigDecimal(7000.0), 10),
        GoldCard(1239, "Roan", BigDecimal(800.0), 15),
        RegularCard(1240, "Vera", BigDecimal(500.0))
    )
}

private fun printCards() {
    println("CardID".padEnd(8) + "Name".padEnd(8) + "Credit".padEnd(8) + "Discount".padEnd(8))

    list.forEach {
        println(
            "${it.cardId}".padEnd(8)
                    + it.name.padEnd(8)
                    + "${it.credit}".padEnd(8)
                    + if (it is GoldCard) "${it.discount}" else ""
        )

    }
}