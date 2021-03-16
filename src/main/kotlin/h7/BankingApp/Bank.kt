package h7.BankingApp

import java.math.BigDecimal
import java.math.RoundingMode

class Bank(val naam:String) {

    private var accounts : MutableList<Account> = mutableListOf()

    init {
    }

    fun addAccount(vararg account: Account) {
        accounts.addAll(account)
    }

    fun deleteAccount(nummer: String) {
        accounts.removeIf { it.accountNumber == nummer }
    }

    fun transferMoney(nummerFrom: String, nummerTo: String, amount: BigDecimal) {
        val accountFrom = accounts.find { it.accountNumber == nummerFrom }
        val accountTo = accounts.find { it.accountNumber == nummerTo }

        try {
            accountFrom?.withdraw(amount, accountTo) ?: throw AccountNotFoundException()
            accountTo?.deposit(amount, accountFrom) ?: throw AccountNotFoundException()
        } catch (e: NotEnoughBalanceException) {
            println(e.message)
        } catch (e: AccountNotFoundException) {
            println(e.message)
        }
    }

    fun printAccounts() {
        accounts.stream()
            .forEach {
                println("Account with account number ${it.accountNumber} " +
                        "would get €${it.calculateInterest().setScale(2, RoundingMode.HALF_UP)} " +
                        "in interest")
            }
    }

    fun getAmountOfAccounts(): Int {
        return accounts.size
    }
}