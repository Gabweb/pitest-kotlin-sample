package de.esolutions.pitest.showcase

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class HelloWorldTest {
    @Test
    fun `should print Hello World`() {
        val result = foo(false, true)
        assertEquals("Bar", result)
    }

    @Test
    fun `should print Hello World2`() {
        val result = foo(true, false)
        assertEquals("Bar", result)
    }
}