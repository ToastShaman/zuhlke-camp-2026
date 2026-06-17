plugins {
    kotlin("jvm") version "2.3.21"
    id("com.google.devtools.ksp") version "2.3.9"
}

group = "com.github.toastshaman"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val http4kVersion = "6.53.0.0"
    val kotshiVersion = "4.0.0"
    val junitVersion = "6.1.0"

    implementation(platform("org.http4k:http4k-bom:$http4kVersion"))

    implementation("org.http4k:http4k-core")
    implementation("org.http4k:http4k-server-jetty")
    implementation("org.http4k:http4k-client-okhttp")
    implementation("org.http4k:http4k-format-moshi")
    runtimeOnly("org.slf4j:slf4j-simple:2.0.17")

    implementation("com.squareup.moshi:moshi:1.15.2")
    implementation("se.ansman.kotshi:api:$kotshiVersion")
    ksp("se.ansman.kotshi:compiler:$kotshiVersion")

    testImplementation(platform("org.junit:junit-bom:$junitVersion"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("io.strikt:strikt-core:0.35.1")
    testImplementation("net.javacrumbs.json-unit:json-unit-assertj:5.1.2")
}

kotlin {
    jvmToolchain(25)
}

tasks.test {
    useJUnitPlatform()
}