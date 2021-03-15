package h7.BankingApp

import java.math.BigDecimal
import java.math.RoundingMode

fun main() {

    var a1 = Account("1", BigDecimal(500))
    var a2 = Account("2", BigDecimal(300))
    var allAccounts = mutableListOf(a1, a2)

    a1.sendMoney(a2, BigDecimal(25))
    println(a2.balance)
    a2.addInterest()
    println(a2.balance)

    allAccounts.stream()
            .forEach {
                println("Account with account number ${it.accountNumber} " +
                        "would get €${it.calculateInterest().setScale(2, RoundingMode.HALF_UP)} " +
                        "in interest")
            }
}