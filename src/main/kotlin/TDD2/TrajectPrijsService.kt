package TDD2

class TrajectPrijsService {

    lateinit var trajectNaarTrajectEenhedenService : TrajectNaarTrajectEenhedenService
    lateinit var trajectEenhedenNaarPrijsService : TrajectEenhedenNaarPrijsService

    fun getTrajectPrijs(from: String, to: String): Int {
        try {
            val eenheden = trajectNaarTrajectEenhedenService.getTrajectEenheden(from, to)
            return trajectEenhedenNaarPrijsService.getPriceTrajectEenheden(eenheden)
        } catch(e: InvalidLocationException) {
            throw e
        }
    }
}