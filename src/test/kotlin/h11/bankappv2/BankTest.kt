package h11.bankappv2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal

internal class BankTest {
    private var bank: Bank = Bank("ING")

    @Test
    fun transferMoney() {
        val account1 = bank.createAccount(AccountType.CHECKING)
        val account2 = bank.createAccount(AccountType.CHECKING)
        account1.balance = BigDecimal(100)
        account2.balance = BigDecimal(100)

        bank.transferMoney(account1.accountNumber, account2.accountNumber, BigDecimal.TEN)

        assertEquals(BigDecimal(90), account1.balance)
        assertEquals(BigDecimal(110), account2.balance)
    }

    @Test
    fun createAccount() {
        val account1 = bank.createAccount(AccountType.CHECKING)
        val account2 = bank.createAccount(AccountType.SAVINGS)
        account1.balance = BigDecimal(100)
        account2.balance = BigDecimal(100)
        bank.setInterestRateOfAccountTo(account2.accountNumber, BigDecimal(10))

        assertEquals(2, bank.getAmountOfAccounts())
        assertEquals(BigDecimal.TEN.setScale(2), bank.calculateInterestOfAccount(account2.accountNumber).setScale(2))
        assertThrows<IllegalArgumentException>() {
            bank.calculateInterestOfAccount(account1.accountNumber)
        }

        bank.printAccounts()
    }
}