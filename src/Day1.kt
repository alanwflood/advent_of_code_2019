import java.io.File
import kotlin.math.floor

// Day 1: The Tyranny of the Rocket Equation

// Part 1
fun getFuelList(): List<Int> = File("assets/Day1.txt").readLines().map { it.toInt() }

fun fuelCounterUpper(mass: Int): Int {
   return (floor(mass / 3.0) - 2).toInt()
}

// Part 2
fun getFuelOfFuel(sum: Int = 0, fuel: Int): Int {
   val newFuel = fuelCounterUpper(fuel)
   if (newFuel > 0) { return getFuelOfFuel(sum + newFuel, newFuel) }
   return sum
}

fun totalFuelCount(): Int = getFuelList().fold(0) { sum, mass -> sum + getFuelOfFuel(fuel = mass) }

fun main(args: Array<String>) {
   val count = totalFuelCount()
   println(count)
}

