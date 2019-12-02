import kotlin.test.assertEquals
import org.junit.Test

class Day2Tests {
    // Part 1
    @Test
    fun testRunOps() {
        assertEquals(listOf(3500,9,10,70,2,3,11,0,99,30,40,50), runOps(listOf(1,9,10,3,2,3,11,0,99,30,40,50)))
        assertEquals(listOf(30,1,1,4,2,5,6,0,99), runOps(listOf(1,1,1,4,99,5,6,0,99)))
    }
}
