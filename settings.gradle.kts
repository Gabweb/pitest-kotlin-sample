pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
    
}
rootProject.name = "pitest-showcase"
include("src:main:java")
findProject(":src:main:java")?.name = "java"
