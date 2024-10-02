package de.esolutions.pitest.showcase

fun foo(arg1: Boolean, arg2: Boolean): String {
    // According to arcmutate, one mutation with "replaced equality check with false" survives.
    // Replacing arg1, arg2 or both args with false will always result in a failing test.
    return if (arg1  || arg2) {
        "Bar"
    } else {
        "Foo"
    }
}