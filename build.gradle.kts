import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.5"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.31"
    kotlin("plugin.spring") version "1.5.31"
}

group = "ru.kirill.vasilev"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

extra["springCloudVersion"] = "2020.0.4"

dependencies {
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-configuration-processor
    implementation("org.springframework.boot:spring-boot-configuration-processor:2.5.5")

    implementation("io.klogging:klogging-jvm:0.4.0")

    implementation("org.springframework.boot:spring-boot-starter-web:2.5.4")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.5")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:3.0.3")
    compileOnly("org.projectlombok:lombok:1.18.20")
    developmentOnly("org.springframework.boot:spring-boot-devtools:2.5.4")
    annotationProcessor("org.projectlombok:lombok:1.18.20")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:2.5.4")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.5.5")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
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
