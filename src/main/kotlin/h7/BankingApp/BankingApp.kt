package h7.BankingApp

import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    val b = Bank("Bank")

    var a1 = Account("1", BigDecimal(500))
    var a2 = Account("2", BigDecimal(300))

    b.addAccount(a1, a2)

    b.transferMoney("1", "2", BigDecimal(25))
    println(a2.balance)
    a2.addInterest()
    println(a2.balance)

    b.printAccounts()
}