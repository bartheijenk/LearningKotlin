package TDD2

class TrajectEenhedenNaarPrijsService: ITrajectPriceService {

    override fun getPriceTrajectEenheden(aantalTrajectEenheden: Int): Int {
        return aantalTrajectEenheden * 3
    }
}