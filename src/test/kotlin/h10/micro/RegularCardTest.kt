package h10.micro

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.math.BigDecimal

internal class RegularCardTest {

    var card = RegularCard(1, "Henk", BigDecimal(120))

    @Test
    fun pay() {
        assertTrue(card.pay(100))

        assertEquals(20, card.credit.toInt())

    }

    @Test
    fun `Not enough balance should return false` () {
        assertFalse(card.pay(200))
        assertEquals(120, card.credit.toInt())
    }
}