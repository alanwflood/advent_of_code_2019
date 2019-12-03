import kotlin.test.assertEquals
import org.junit.Test

class Day3Tests {
    val day = Day3()
    val testDataA = listOf("R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83")
    val testDataB = listOf("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7")

    // Part 1
    @Test
    fun testDay3Part1() {
        assertEquals(159, day.part1(testDataA))
        assertEquals(135, day.part1(testDataB))
    }

    @Test
    fun testDay3Part2() {
        assertEquals(610, day.part2(testDataA))
        assertEquals(410, day.part2(testDataB))
    }
}
