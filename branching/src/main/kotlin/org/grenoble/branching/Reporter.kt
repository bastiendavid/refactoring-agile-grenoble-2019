package org.grenoble.branching

class Reporter {
    private val logs = ArrayList<String>()

    fun addLog(log: String) {
        logs.add(log)
    }

    fun printLogs() {
        logs.forEach { println(it) }
    }
}
