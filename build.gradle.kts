plugins {
    kotlin("jvm") version "1.9.20"
    id("info.solidsoft.pitest") version "1.15.0"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    pitest("com.groupcdg.arcmutate:base:1.2.2")
    pitest("com.groupcdg.pitest:pitest-kotlin-plugin:1.1.6")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

pitest {
    pitestVersion.set("1.15.8")
    targetClasses.set(setOf("de.esolutions.*"))
    junit5PluginVersion.set("1.2.1")
    verbose.set(true)
}