package h7.BankingApp

import java.math.BigDecimal
import java.util.stream.Collectors

class Account(val accountNumber: String, initialBalance: BigDecimal, var interestRate: Float = 1.0F) {

    var balance: BigDecimal = initialBalance

    private var transactions = emptyList<Transaction>().toMutableList()

    fun sendMoney(accountTo: Account, amount: BigDecimal) {
        if (amount <= balance) {
            val transaction = Transaction(this, accountTo, amount)
            transactions.add(transaction)
            accountTo.transactions.add(transaction)
            balance -= amount
            accountTo.balance += amount
        } else {
            throw NotEnoughBalanceException()
        }
    }

    fun calculateInterest() : BigDecimal {
        return balance * (interestRate / 100).toBigDecimal()
    }

    fun addInterest() {
        balance += calculateInterest()
    }
}

data class Transaction(val accountFrom: Account, val accountTo :Account, val amount:BigDecimal)
