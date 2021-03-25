package h10

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

class Android : Human(), Chargeable {


    override fun greet(): String {
        action()
        return "I'm only half human, but human still... My energy level is $charge%"
    }

    override var charge: Int = 0
        set(value) {
            when {
                value > 100 -> {
                    throw IllegalArgumentException("Charge can't exceed 100%")
                }
                value < 0 -> {
                    throw IllegalArgumentException("Charge can't be negative")
                }
                else -> field = value
            }
        }

    //    override function of chargeable
    override fun chargeUp(amount: Int): Int {
        try {
            charge += amount
            logger.debug { "Charged by $amount" }
        } catch (e: IllegalArgumentException) {
            if (amount + charge > 100) {
                charge = 100
                logger.error(e) { "amount was larger than 100" }
            } else {
                charge = 0
                logger.error(e) { "Amount was negative" }
            }

        }
        return charge
    }

    //    personal addiction, if Android does an action it uses charge to do that action
    fun action() {
        logger.debug { "Charge level at: $charge" }
        charge -= 10
    }
}