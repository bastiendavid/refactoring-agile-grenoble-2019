package org.grenoble.parallelchange

class Board(private val rules: Rules, vararg players: Player) {
    private val players: ArrayList<Player> = arrayListOf(*players)

    fun displayed(): String {
        if (players.isEmpty()) {
            return "Waiting for players"
        }

        return players
            .sortedByDescending { rules.score(it.redChips, it.blueChips) }
            .fold("Ranking:\n") { acc, player ->
                "$acc${player.name} with ${rules.score(
                    player.redChips, player.blueChips
                )} points\n"
            }
    }
}
