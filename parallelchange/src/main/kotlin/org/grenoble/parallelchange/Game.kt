package org.grenoble.parallelchange

class Game(private val rules: Rules, vararg players: Player) {
    private val players: ArrayList<Player> = arrayListOf(*players)

    fun winner(): Player? = players.maxBy { rules.score(it.redChips, it.blueChips) }
}
