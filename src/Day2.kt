    import java.io.File

    fun readOps(): List<Int> = File("assets/Day2.txt").readText().trim().split(",").map { it.toInt() }

    fun runOps(list: List<Int>): List<Int> {
        var opList = list.toMutableList()
        loop@ for((index, value) in opList.withIndex()) {
            if (index % 4 == 0) {
                if (value == 99) break@loop

               val assign1 = opList[index + 1]
               val assign2 = opList[index + 2]
               val answer = opList[index + 3]

                when(value) {
                    1 -> opList[answer] = opList[assign1] + opList[assign2]
                    2 -> opList[answer] = opList[assign1] * opList[assign2]
                    else -> continue@loop
                }
            }
        }
        return opList
    }

    fun getOps(list: List<Int>): Int {
        var answer = 0
        for(noun in (0..99)) {
            for(verb in (0..99)) {
                val newList = list.toMutableList()
                newList[1] = noun;
                newList[2] = verb;
                if (runOps(newList)[0] == 19690720) {
                    answer = "$noun$verb".toInt()
                }
            }
        }
        return answer
    }

    fun main(args: Array<String>) {
        println(getOps(readOps()))
    }