class Day4 {
    private fun createRange(input: String): IntRange =
        input.split("-").map { it.toInt() }.zipWithNext().first().run { first..second }

    fun part1(input: String): Int {
        val range = createRange(input)
        val matches = mutableListOf<Int>()
        range.forEach { number ->
            val values = number.toString().map { it.toString().toInt() }
            val testableValues = values.withIndex().drop(1)

            val hasMatch = testableValues.any { (index, value) -> value == values[index - 1] }
            val isAscending = testableValues.all { (index, value) -> values[index - 1] <= value }

            if (hasMatch && isAscending) matches.add(number)
        }
        println(matches)
        println(matches.first())
        return matches.size
    }
}


fun main(args: Array<String>) {
    val input = "353096-843212"
    val day = Day4()

    println((day.part1(input)))
}
