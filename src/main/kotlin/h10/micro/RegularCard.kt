package h10.micro

import mu.KotlinLogging
import java.math.BigDecimal

private val logger = KotlinLogging.logger {}
class RegularCard(
    override val cardId: Int,
    override var name : String,
    override var credit: BigDecimal
) : Card(
    cardId, name, credit
){
    override fun pay(amount: Int): Boolean {
        logger.info { "Starting payment..." }
        val bigAmount = amount.toBigDecimal()
        return when {
            credit - bigAmount < BigDecimal.ZERO -> {
                logger.info { "Not enough credit" }
                false
            }
            else -> {
                credit -= bigAmount
                logger.info { "Payment successful, new balance is $credit" }
                true
            }
        }
   }
}