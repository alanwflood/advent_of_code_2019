import java.io.File
import kotlin.math.abs

class Day3 {
    data class Point(val x: Int, val y: Int) {
        fun manhattan(other: Point) = abs(x - other.x) + Math.abs(y - other.y)
    }

    data class LineOperation(val direction: Char, val value: Int)

    val startingPoint = Point(0, 0)

    private fun toPoints(data: List<LineOperation>): MutableList<Point> {
        var current = Point(0, 0)
        val points = mutableListOf<Point>()

        data.forEach { action: LineOperation ->
            repeat(action.value) {
                val newX = when (action.direction) {
                    'R' -> current.x + 1
                    'L' -> current.x - 1
                    else -> current.x
                }

                val newY = when (action.direction) {
                    'U' -> current.y + 1
                    'D' -> current.y - 1
                    else -> current.y
                }
                current = Point(newX, newY)
                points += current
            }
        }
        return points
    }

    private fun findNearestPoint(intersections: Set<Point>): Point {
        return intersections.minBy { it -> it.manhattan(startingPoint) }!!
    }

    private fun getPoints(data: List<List<LineOperation>>): List<List<Point>> {
        return data.map { toPoints(it) }
    }

    private fun getIntersections(wireA: List<Point>, wireB: List<Point>): Set<Point> = wireA.intersect(wireB)

    private fun getWires(wireData: List<String>): List<List<LineOperation>> {
        return wireData.map { wire ->
            wire.split(",").map {
                LineOperation(it[0], it.substring(1).toInt())
            }
        }
    }

    fun part1(wireData: List<String>): Int {
        val wires = getWires(wireData)
        val points = getPoints(wires)
        val intersections = getIntersections(points[0], points[1])
        return findNearestPoint(intersections).manhattan(startingPoint)
    }

    fun part2(wireData: List<String>): Int {
        val wires = getWires(wireData)
        val points = getPoints(wires)
        val intersections = getIntersections(points[0], points[1])
        return points.map { list ->
            list
                .mapIndexed { distance, point -> point to distance + 1 }
                .filter { intersections.contains(it.first) }
                .toMap()
        }.let { (first, second) ->
            first.map {(point, distance) ->
                distance + second.getValue(point)
            }.min()!!
        }
    }
}



fun main(args: Array<String>) {
    val file = File("assets/Day3.txt").readLines()
    val day = Day3()

    println((day.part1(file)))
    println((day.part2(file)))
}
