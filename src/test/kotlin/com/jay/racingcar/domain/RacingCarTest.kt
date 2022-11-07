package com.jay.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RacingCarTest {
    @Test
    fun `자동차가 ManualStrategy를 만족하면 전진한다`() {
        val racingCar = RacingCar(forwardStrategy())

        racingCar.move()

        assertThat(racingCar.position).isEqualTo(1)
    }

    @Test
    fun `자동차가 StopStrategy를 만족하면 멈춰있는다`() {
        val racingCar = RacingCar(stopStrategy())

        racingCar.move()

        assertThat(racingCar.position).isEqualTo(0)
    }

    private fun forwardStrategy() = object : MovingStrategy {
        override fun move(): Boolean {
            return true
        }
    }

    private fun stopStrategy() = object : MovingStrategy {
        override fun move(): Boolean {
            return false
        }
    }
}