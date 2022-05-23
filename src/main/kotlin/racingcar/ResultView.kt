package racingcar

data class ResultView(val result: List<Round>) {
    fun title() {
        println("실행 결과")
    }

    fun printResult() {
        result.mapIndexed { index, it ->
            roundTitle(index + 1)
            it.result.forEach {
                print(it.name + " : ")
                println(distanceToLetter(it.distance))
            }

            println()
        }

        val winnerNames = result.last().winner().map { it.name }
        println(winnerNames.joinToString(", ") + "가 최종 우승했습니다.")
    }

    private fun distanceToLetter(distance: Int): String {
        return DISTANCE_LETTER.repeat(distance)
    }

    private fun roundTitle(round: Int) {
        println("$round 라운드")
    }

    companion object {
        const val DISTANCE_LETTER = "-"
    }
}