import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.0.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("com.expediagroup.graphql") version "5.3.2"
    kotlin("jvm") version "1.7.20"
    kotlin("plugin.spring") version "1.6.10"
}

group = "com.graphql"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11


repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc:2.7.3")
    implementation("org.springframework.boot:spring-boot-starter-webflux:2.6.3")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.4")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions:1.1.5")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.7.10")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.10")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.6.0")
    implementation("com.expediagroup:graphql-kotlin-spring-server:6.2.2")
    implementation("com.expediagroup:graphql-kotlin-hooks-provider:5.3.2")
    implementation("org.postgresql:postgresql:42.5.0")

    runtimeOnly("com.h2database:h2:1.4.195")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.7.3")
    testImplementation("io.projectreactor:reactor-test:3.4.22")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
springBoot {
    mainClass.set("com.graphql.ApplicationKt")
}
tasks.getByName<Jar>("jar") {
    enabled = false
}
graphql {
    schema {
        packages = listOf("com.graphql.expediagraphql")
    }
}
