package h10.micro

import mu.KotlinLogging
import java.math.BigDecimal

private val logger = KotlinLogging.logger {}

class GoldCard(
    override val cardId: Int,
    override var name: String,
    override var credit: BigDecimal,
    discount: Int
) : Card(
    cardId, name, credit
) {

    var discount = discount
        set(value) {
            if (value > 30 || value < 1) {
                logger.error { "Value discount was not in range" }
                throw IndexOutOfBoundsException("value should be between 1 and 39")
            }
            field = value
        }

    override fun pay(amount: Int): Boolean {
        logger.info { "Starting payment..." }
        var bigAmount = amount.toBigDecimal().setScale(2)
        val bigDecimal = BigDecimal(discount).setScale(2) / BigDecimal(100).setScale(2)
        bigAmount -= bigDecimal* bigAmount

        credit -= bigAmount
        logger.info { "Payment successful, new credit is $credit" }
        return true
    }
}