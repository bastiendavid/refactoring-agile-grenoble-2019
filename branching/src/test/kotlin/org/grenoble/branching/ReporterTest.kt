package org.grenoble.branching

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

internal class ReporterTest {

    private val capturedOut = ByteArrayOutputStream()
    private val originalOut = System.out

    @BeforeEach
    fun `Capture System out`() {
        System.setOut(PrintStream(capturedOut))
    }

    @AfterEach
    fun `Restore System out`() {
        System.setOut(originalOut)
    }

    @Test
    fun `Reporter writes the logs to console out`() {
        // Given
        val reporter = Reporter()
        reporter.addLog("Log 1")
        reporter.addLog("Log 2")
        reporter.addLog("Log 3")

        // When
        reporter.printLogs()

        // Then
        assertThat(String(capturedOut.toByteArray())).isEqualTo("Log 1\nLog 2\nLog 3\n")
    }
}
