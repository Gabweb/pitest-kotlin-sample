package de.esolutions.pitest.showcase

import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class HelloWorldTest {
    @Test
    fun `should print Hello World`() {
        val looper = mockk<Looper>(relaxed = true)
        val cut = HelloWorld(looper)

        cut.helloWorld()

        verify { looper.dump(any(), any()) }
    }
}