# Verter Convention Plugin

`verter-convention-plugin` provides a set of Gradle convention plugins for **org.gamedo.verter** projects.  
They standardize Kotlin/JVM build, test, and code-style configuration, so individual modules stay small and consistent.

Currently included plugins:

- `org.gamedo.verter.conventions.kotlin-jvm`  
  Common conventions for Kotlin/JVM modules: applies `org.jetbrains.kotlin.jvm`, enables JUnit Platform, configures Java 21 toolchain, etc.
- `org.gamedo.verter.conventions.ktlint`  
  Integrates `org.jlleitschuh.gradle.ktlint` and unifies Kotlin code-style checks.

The plugins are published on the Gradle Plugin Portal. Current version example: `0.1.0`.

---

## Quick start

### 1. Configure plugin repositories in `settings.gradle.kts`

```kotlin
pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}
```

### 2. Apply the convention plugins in your module

Example `build.gradle.kts`:

```kotlin
plugins {
    id("org.gamedo.verter.conventions.kotlin-jvm") version "0.1.0"
    id("org.gamedo.verter.conventions.ktlint") version "0.1.0"
}
```

After applying, the module gets:

- Kotlin/JVM plugin (`org.jetbrains.kotlin.jvm`)
- Java 21 toolchain and `jvmTarget = 21`
- JUnit Platform enabled for tests (`useJUnitPlatform()`)
- Unified ktlint configuration (rules and tasks)

In most cases you only need to declare your own dependencies in `dependencies {}`.

---

## Local development

From the repository root:

```bash
./gradlew build
./gradlew publishToMavenLocal
```

Then other projects can consume the locally published plugins via `pluginManagement.repositories { mavenLocal() }`.

To publish to the Gradle Plugin Portal:

```bash
./gradlew publishPlugins
```

Make sure your machine has Plugin Portal credentials in `~/.gradle/gradle.properties`:

```properties
gradle.publish.key=yourPluginPortalKey
gradle.publish.secret=yourPluginPortalSecret
```

---

## Versions & compatibility

- Written in Gradle Kotlin DSL; requires Gradle 8.x or newer.
- Recommended to run Gradle with Java 17 or 21. Consumer modules are compiled with Java 21 via toolchains.

Compatibility notes will be expanded as new plugin versions are released.

---

## License

Licensed under the Apache License, Version 2.0. See `LICENSE` in the repository root.

