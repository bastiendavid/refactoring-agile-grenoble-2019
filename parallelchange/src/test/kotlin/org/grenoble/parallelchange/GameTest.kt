package org.grenoble.parallelchange

import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class GameTest {

    private lateinit var player1: Player
    private lateinit var player2: Player
    private lateinit var player3: Player

    @BeforeEach
    fun initPlayers() {
        player1 = Player("Player 1", 4, 3)
        player2 = Player("Player 2", 2, 2)
        player3 = Player("Player 3", 1, 1)
    }

    @Test
    fun `The player with the greatest score wins the game`() {
        val rules = mockk<Rules>()
        every { rules.score(player1.redChips, player1.blueChips) } returns 9
        every { rules.score(player2.redChips, player2.blueChips) } returns 8
        every { rules.score(player3.redChips, player3.blueChips) } returns 7
        val game = Game(rules, player1, player2, player3)

        assertThat(game.winner()).isEqualTo(player1)
    }

    @Test
    fun `A game without players has no winner`() {
        val game = Game(Rules())
        assertThat(game.winner()).isNull()
    }
}
