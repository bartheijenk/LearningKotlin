package h7.BankingApp

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.TestInstance
import java.math.BigDecimal

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
internal class BankTest {
    private val bank: Bank
    private val basicBalance = BigDecimal(100)
    private val a1: Account
    private val a2: Account
    private val a3: Account
    init {
        bank = Bank("bank")

        a1 = Account("1", basicBalance)
        a2 = Account("2", basicBalance)
        a3 = Account("3", basicBalance)

        bank.addAccount(a1, a2, a3)
    }

    @Test
    fun addAccount() {

        Assertions.assertEquals(3, bank.getAmountOfAccounts())
    }

    @Test
    fun deleteAccount() {

        bank.deleteAccount("3")

        Assertions.assertEquals(2, bank.getAmountOfAccounts())

    }

    @Nested
    inner class transferMoneyTest() {
        @Test
        fun `Transfer money normally`() {
            Assertions.assertTrue(bank.transferMoney(a1.accountNumber, a2.accountNumber, BigDecimal.TEN))

            Assertions.assertEquals(basicBalance - BigDecimal.TEN, a1.balance)
            Assertions.assertEquals(basicBalance + BigDecimal.TEN, a2.balance)
        }

        @Test
        fun `Transfer too much money` () {
            Assertions.assertFalse(bank.transferMoney(a1.accountNumber, a2.accountNumber, basicBalance + BigDecimal.ONE))

            Assertions.assertEquals(basicBalance, a1.balance)
            Assertions.assertEquals(basicBalance, a2.balance)
        }

        @Test
        fun `Account doesn't exist` () {
            Assertions.assertFalse(bank.transferMoney("This one does not exist", a2.accountNumber, BigDecimal.TEN))


        }
    }
}