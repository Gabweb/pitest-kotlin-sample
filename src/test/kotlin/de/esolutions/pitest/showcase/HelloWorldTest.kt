package de.esolutions.pitest.showcase

import org.junit.jupiter.api.Test

class HelloWorldTest {
    @Test
    fun `should print "Hello World"`() {
        val cut = HelloWorld()

        cut.helloWorld()
    }
}