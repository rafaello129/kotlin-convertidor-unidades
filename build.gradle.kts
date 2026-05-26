plugins {
    kotlin("jvm") version "2.0.21"
    application
}

group = "edu.universidad"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass.set("MainKt")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}
