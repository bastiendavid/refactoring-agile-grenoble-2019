package org.grenoble.parallelchange

class Rules {
    companion object {
        @JvmStatic
        val RED_CHIP_VALUE = 4
        @JvmStatic
        val BLUE_CHIP_VALUE = 2
    }

    fun score(redChips: Int, blueChips: Int): Int {
        return redChips * RED_CHIP_VALUE + blueChips * BLUE_CHIP_VALUE
    }
}
