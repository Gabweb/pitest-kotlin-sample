plugins {
    kotlin("jvm") version "1.8.20"
    id("info.solidsoft.pitest") version "1.9.0"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

pitest {
    targetClasses.set(setOf("de.esolutions.*"))
    junit5PluginVersion.set("1.0.0")
}