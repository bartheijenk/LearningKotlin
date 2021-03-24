package h10.micro

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.math.BigDecimal

internal class GoldCardTest {

    @Test
    fun pay() {
        val card = GoldCard(1, "Henk", BigDecimal(50), 20)

        assertTrue(card.pay(100))

        assertEquals(-30, card.credit.toInt())
    }
}