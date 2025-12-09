plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`
}

group = "org.gamedo.verter"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenLocal()
    gradlePluginPortal()
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

dependencies {
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.ktlint.gradle)
}

gradlePlugin {
    plugins {
        create("kotlinJvmConvention") {
            id = "org.gamedo.verter.conventions.kotlin-jvm"
            implementationClass = "org.gamedo.verter.conventions.kotlin.KotlinJvmConventionPlugin"
        }
        create("ktlintConvention") {
            id = "org.gamedo.verter.conventions.ktlint"
            implementationClass = "org.gamedo.verter.conventions.ktlint.KtlintConventionPlugin"
        }
    }
}

publishing {
    repositories {
        mavenLocal()
    }
}
