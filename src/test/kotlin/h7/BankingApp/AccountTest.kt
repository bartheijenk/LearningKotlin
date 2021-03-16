package h7.BankingApp

import org.junit.jupiter.api.*
import java.math.BigDecimal

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
internal class AccountTest {
    private var account: Account
    private val basicBalance: BigDecimal = BigDecimal(100)

    init {
        account = Account("1", basicBalance)
        account.interestRate = 1.0F
    }

    @Nested
    inner class BalanceTest {

        @Test
        fun `testing getBalance for coverage`() {
            assert(account.balance == basicBalance)
        }

        @Test
        fun `testing setBalance for coverage`() {
            account.balance = BigDecimal(200)
            assert(account.balance.toInt() == 200)
        }
    }

    @Nested
    inner class TransferTests {

        @Test
        fun `Normal withdraw`() {
            val amount = BigDecimal(20)

            account.withdraw(amount)

            assert(account.balance == basicBalance - amount)
        }

        @Test
        fun `Not enough balance`() {
            val amount = basicBalance + BigDecimal(1)

            assertThrows<NotEnoughBalanceException> {
                account.withdraw(amount)
            }

            assert(account.balance == basicBalance)
        }

        @Test
        fun `Deposit money`() {
            val amount = BigDecimal(25)

            account.deposit(amount)

            assert(account.balance == basicBalance + amount)
        }
    }

    @Nested
    inner class InterestTest {
        private lateinit var expectedAmountInterest: BigDecimal

        @BeforeEach
        fun setup() {
            expectedAmountInterest = BigDecimal.ONE
        }

        @Test
        fun calculateInterest() {

            Assertions.assertEquals(expectedAmountInterest.setScale(2), account.calculateInterest())
        }

        @Test
        fun addInterest() {
            account.addInterest()
            val expected = basicBalance + expectedAmountInterest
            Assertions.assertEquals(expected.setScale(2), account.balance)
        }
    }
}
