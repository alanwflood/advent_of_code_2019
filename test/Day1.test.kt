import kotlin.test.assertEquals
import org.junit.Test

class Day1Tests {
    // Part 1
    @Test
    fun testFuelCounterUpper() {
        assertEquals(654, fuelCounterUpper(1969))
        assertEquals(33583, fuelCounterUpper(100756))
    }

    // Part 2
    @Test
    fun testFuelOfFuel() {
        assertEquals(966, getFuelOfFuel(fuel = 1969))
        assertEquals(50346, getFuelOfFuel(fuel = 100756))
    }
}
