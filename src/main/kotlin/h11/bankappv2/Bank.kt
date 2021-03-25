package h11.bankappv2

import java.math.BigDecimal
import java.math.RoundingMode

class Bank(val naam: String) {

    private var bankAccounts: MutableList<BankAccount> = mutableListOf()
    private val nextAccountNumber: String
        get() {
            return (getAmountOfAccounts() + 1).toString()
        }

    companion object {
        val standardInterestRate: BigDecimal = BigDecimal.TEN
    }

    init {
    }

    fun deleteAccount(nummer: String) {
        bankAccounts.removeIf { it.accountNumber == nummer }
    }

    private fun findSavingsAccount(accountNumber: String): SavingsAccount {
        val account = findAccount(accountNumber)
        if (account !is SavingsAccount)
            throw IllegalArgumentException()
        return account
    }

    private fun findAccount(accountNumber: String): BankAccount {
        return bankAccounts.find { it.accountNumber == accountNumber } ?: throw AccountNotFoundException()
    }

    fun transferMoney(nummerFrom: String, nummerTo: String, amount: BigDecimal): Boolean {
        try {
            findAccount(nummerFrom).withdraw(amount)
            findAccount(nummerTo).deposit(amount)
        } catch (e: NotEnoughBalanceException) {
            println(e.message)
            return false
        } catch (e: AccountNotFoundException) {
            println(e.message)
            return false
        }
        return true
    }

    fun printAccounts() {
        bankAccounts.stream()
                .forEach {
                    println(
                            if (it is SavingsAccount) {
                                "Savings account"

                            } else {
                                "Checkin account"
                            } +
                                    " with account number ${it.accountNumber} " +
                                    "Has a balance of: €${it.balance.setScale(2, RoundingMode.HALF_UP)}" +
                                    if (it is SavingsAccount) {
                                        " would get €${it.calculateInterest().setScale(2, RoundingMode.HALF_UP)} in interest"
                                    } else
                                        ""
                    )
                }
    }

    fun getAmountOfAccounts(): Int {
        return bankAccounts.size
    }

    fun calculateInterestOfAccount(accountNumber: String): BigDecimal {
        return findSavingsAccount(accountNumber).calculateInterest()
    }

    fun createAccount(accountType: AccountType): BankAccount {
        val account: BankAccount = when (accountType) {
            AccountType.SAVINGS -> SavingsAccount(nextAccountNumber, BigDecimal.ZERO, BigDecimal.TEN)
            AccountType.CHECKING -> CheckingAccount(nextAccountNumber)
        }
        bankAccounts.add(account)
        return account
    }

    fun setInterestRateOfAccountTo(accountNumber: String, newInterestRate: BigDecimal) {
        findSavingsAccount(accountNumber).interestRate = newInterestRate
    }

    abstract inner class BankAccount(
            val accountNumber: String,
            var balance: BigDecimal) {

        private var transactions = emptyList<Transaction>().toMutableList()

        fun withdraw(amount: BigDecimal, accountTo: BankAccount? = null) {
            if (amount >= balance) {
                throw h7.BankingApp.NotEnoughBalanceException()
            } else {
                balance -= amount
                if (accountTo != null) {
                    transactions.add(Transaction(accountTo, amount))
                }
            }
        }

        fun deposit(amount: BigDecimal, accountFrom: BankAccount? = null) {
            balance += amount

            if (accountFrom != null) {
                transactions.add(Transaction(accountFrom, amount))
            }
        }
    }

    private inner class CheckingAccount(accountNumber: String,
                                        initialBalance: BigDecimal = BigDecimal.ZERO)
        : BankAccount(accountNumber, initialBalance) {
    }

    private inner class SavingsAccount(accountNumber: String,
                                       balance: BigDecimal = BigDecimal.ZERO,
                                       var interestRate: BigDecimal = standardInterestRate)
        : BankAccount(accountNumber,
            balance) {
        fun calculateInterest(): BigDecimal {
            return balance.setScale(5) * (interestRate.setScale(5) / BigDecimal(100).setScale(5))
        }

        fun addInterest() {
            balance += calculateInterest()
        }
    }

    data class Transaction(val bankAccountTo: BankAccount, val amount: BigDecimal)
}

