package org.grenoble.parallelchange

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class RulesTest {

    @ParameterizedTest
    @MethodSource("expectedScores")
    fun `score is the sum of red chips times 4, and blue chips time 2`(
        redChips: Int,
        blueChips: Int,
        expectedScore: Int
    ) {
        Assertions.assertThat(Rules().score(redChips, blueChips)).isEqualTo(expectedScore)
    }

    companion object {
        @JvmStatic
        fun expectedScores(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(2, 2, 12),
                Arguments.of(5, 3, 26),
                Arguments.of(3, 6, 24)
            )
        }
    }
}
