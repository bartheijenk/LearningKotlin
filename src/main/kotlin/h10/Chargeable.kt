package h10

interface Chargeable {
    var charge : Int

    fun chargeUp(amount: Int) : Int
}