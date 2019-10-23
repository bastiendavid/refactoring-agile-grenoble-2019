package org.grenoble.parallelchange

import org.assertj.core.api.Assertions.assertThat
import org.grenoble.parallelchange.Dice.*
import org.junit.jupiter.api.Test

internal class DiceScoreCalculationTest {

    @Test
    fun `Score is 100 if three dice have the same value`() {
        assertThat(DiceScoreCalculation().score(FIVE, FIVE, FIVE)).isEqualTo(100)
        assertThat(DiceScoreCalculation().score(TWO, TWO, TWO)).isEqualTo(100)
    }

    @Test
    fun `Score is sum of dice multiplied by 2 if has twice the same value`() {
        assertThat(DiceScoreCalculation().score(FIVE, FIVE, THREE)).isEqualTo(26)
        assertThat(DiceScoreCalculation().score(SIX, SIX, FOUR)).isEqualTo(32)
    }

    @Test
    fun `Score is sum of dice if all 3 dice have a different value`() {
        assertThat(DiceScoreCalculation().score(ONE, TWO, THREE)).isEqualTo(6)
        assertThat(DiceScoreCalculation().score(SIX, FOUR, TWO)).isEqualTo(12)
    }
}
