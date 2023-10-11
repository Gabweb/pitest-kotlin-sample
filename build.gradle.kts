plugins {
    kotlin("jvm") version "1.9.10"
    id("info.solidsoft.pitest") version "1.9.11"
}

repositories {
    mavenCentral()
}

val mockk = "1.12.3"

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("io.mockk:mockk:$mockk")
    testImplementation("io.mockk:mockk-agent-jvm:$mockk")
    pitest("com.groupcdg.arcmutate:base:1.2.2")
    pitest("com.groupcdg.pitest:pitest-kotlin-plugin:1.1.2")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

pitest {
    pitestVersion.set("1.15.1")
    targetClasses.set(setOf("de.esolutions.*"))
    junit5PluginVersion.set("1.0.0")
    verbose.set(true)
}