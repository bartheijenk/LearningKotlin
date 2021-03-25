package h11.bankappv2

import java.math.BigDecimal

fun main() {
    val b = Bank("Bank")

    val a1 = Account("1", BigDecimal(500))
    val a2 = Account("2", BigDecimal(300))

    b.addAccount(a1, a2)

    b.transferMoney("1", "2", BigDecimal(25))
    println(a2.balance)
    a2.addInterest()
    println(a2.balance)

    b.printAccounts()
}