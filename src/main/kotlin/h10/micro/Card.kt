package h10.micro

import java.math.BigDecimal

abstract class Card(
    open val cardId: Int,
    open var name: String,
    open var credit: BigDecimal
)
{
    abstract fun pay(amount: Int): Boolean
}