package study.racingcar

import kotlin.random.Random

class RacingGame(private val moveStrategy: MoveStrategy) {

    private lateinit var _cars: Array<Car>

    fun readyGame(carCount: Int): Boolean {
        _cars = Array(carCount) { Car() }
        return true
    }

    fun raceCars(): List<Car> {
        for (car in _cars) {
            moveCarOrNot(car)
        }
        return _cars.toList()
    }

    private fun moveCarOrNot(car: Car) {
        if (moveStrategy.isMoveCar(Random.nextInt(9))) {
            car.moveCar()
        }
    }
}