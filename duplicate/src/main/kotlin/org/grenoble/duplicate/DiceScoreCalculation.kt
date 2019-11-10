package org.grenoble.duplicate

class DiceScoreCalculation {

    fun score(dice1: Dice, dice2: Dice, dice3: Dice): Int {
        var score = 0
        if (dice1 == dice2 && dice2 == dice3) {
            score = 100
        } else {
            if (dice1 == dice2 || dice1 == dice3 || dice2 == dice3) {
                score = (dice1.value + dice2.value + dice3.value) * 2
            } else {
                score = dice1.value + dice2.value + dice3.value
            }
        }
        return score
    }
}

enum class Dice(val value: Int) {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6)
}


