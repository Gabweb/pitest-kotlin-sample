package de.esolutions.pitest.showcase

import java.util.function.Consumer

class HelloWorld(private val looper: Looper) {
    fun helloWorld() {
        println("Hello World")

        val bw = System.out.bufferedWriter()
        bw.also {
            looper.dump(it::appendLine, "jo")
        }
    }
}

interface Looper {
    fun dump(printer: Consumer<String>, prefix: String)
}