package org.grenoble.parallelchange

import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.math.exp

internal class BoardTest {

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
    fun `Displays a default message when no players has join the game`() {
        val display = Board(Rules()).displayed()
        assertThat(display).isEqualTo("Waiting for players")
    }

    @Test
    fun `Displays a board with players sorted by score`() {
        val rules = mockk<Rules>()
        every { rules.score(player1.redChips, player1.blueChips) } returns 9
        every { rules.score(player2.redChips, player2.blueChips) } returns 8
        every { rules.score(player3.redChips, player3.blueChips) } returns 7
        val board = Board(rules, player1, player2, player3)
        val expectedDisplayed = """Ranking:
Player 1 with 9 points
Player 2 with 8 points
Player 3 with 7 points
"""
        assertThat(board.displayed()).isEqualTo(expectedDisplayed)
    }
}
