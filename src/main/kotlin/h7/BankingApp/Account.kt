package h7.BankingApp

import java.math.BigDecimal

class Account(val accountNumber: String, initialBalance: BigDecimal, var interestRate: Float = 1.0F) {

    var balance: BigDecimal = initialBalance

    private var transactions = emptyList<Transaction>().toMutableList()


    fun calculateInterest(): BigDecimal {
        return balance * (interestRate / 100).toBigDecimal()
    }

    fun addInterest() {
        balance += calculateInterest()
    }

    fun withdraw(amount: BigDecimal, accountTo: Account? = null) {
        if (amount >= balance) {
            throw NotEnoughBalanceException()
        } else {
            balance -= amount
            if (accountTo != null) {
                transactions.add(Transaction(accountTo, amount))
            }
        }
    }

    fun deposit(amount: BigDecimal, accountFrom: Account? = null) {
        balance += amount

        if (accountFrom != null) {
            transactions.add(Transaction(accountFrom, amount))
        }
    }
}

data class Transaction(val accountTo: Account, val amount: BigDecimal)
