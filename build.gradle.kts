plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`
    alias(libs.plugins.gradle.plugin.publish)
}

group = "org.gamedo.verter"
version = "0.1.0"

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
    website.set("https://github.com/pcloves/verter-convention-plugin")
    vcsUrl.set("https://github.com/pcloves/verter-convention-plugin.git")

    plugins {
        register("kotlinJvmConvention") {
            id = "org.gamedo.verter.conventions.kotlin-jvm"
            displayName = "Verter Kotlin JVM conventions"
            description = "Kotlin/JVM conventions for org.gamedo.verter projects"
            implementationClass = "org.gamedo.verter.conventions.kotlin.KotlinJvmConventionPlugin"
            tags.set(listOf("kotlin", "conventions"))
        }
        register("ktlintConvention") {
            id = "org.gamedo.verter.conventions.ktlint"
            displayName = "Verter ktlint conventions"
            description = "ktlint conventions for org.gamedo.verter projects"
            implementationClass = "org.gamedo.verter.conventions.ktlint.KtlintConventionPlugin"
            tags.set(listOf("ktlint", "conventions"))
        }
    }
}

publishing {
    repositories {
        mavenLocal()
    }
}
