package TDD2

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class TrajectPrijsServiceTest {

    @MockK
    lateinit var eenhedenService: TrajectNaarTrajectEenhedenService

    @MockK
    lateinit var prijsService: TrajectEenhedenNaarPrijsService

    @InjectMockKs
    private var trajectPrijsService : TrajectPrijsService = TrajectPrijsService()

    @BeforeEach
    fun setup() = MockKAnnotations.init(this)

    @Test
    fun getTrajectPrijs() {
        //given en when

        every { eenhedenService.getTrajectEenheden("amsterdam", "utrecht") } returns 2
        every { prijsService.getPriceTrajectEenheden(2) } returns 820

        assertEquals(820, trajectPrijsService.getTrajectPrijs("amsterdam", "utrecht"))
    }

    @Test
    fun `Invalid Location gets an exception`() {
        every { eenhedenService.getTrajectEenheden("Dit Bestaat niet", "Utrecht") } throws InvalidLocationException()
        every { prijsService.getPriceTrajectEenheden(2) } returns 820

        assertThrows<InvalidLocationException> { trajectPrijsService.getTrajectPrijs("Dit Bestaat niet", "Utrecht") }
    }
}