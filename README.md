# Verter Convention Plugin

`verter-convention-plugin` 是一组面向 **org.gamedo.verter** 系列项目的 Gradle 约定插件，用来统一 Kotlin/JVM 项目的编译、测试以及代码风格配置，尽量减少每个模块里重复的 build 脚本。

当前提供两个插件：

- `org.gamedo.verter.conventions.kotlin-jvm`  
  面向 Kotlin/JVM 模块的通用约定：应用 `org.jetbrains.kotlin.jvm`、启用 JUnit Platform、配置 Java 21 toolchain 等。
- `org.gamedo.verter.conventions.ktlint`  
  集成 `org.jlleitschuh.gradle.ktlint`，统一 Kotlin 代码风格检查配置。

插件在 Gradle Plugin Portal 上发布，版本号示例为 `0.1.0`。

---

## 快速开始

### 1. 在 `settings.gradle.kts` 中配置插件仓库

```kotlin
pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}
```

### 2. 在模块中应用约定插件

以某个 Kotlin/JVM 子模块为例（`build.gradle.kts`）：

```kotlin
plugins {
    id("org.gamedo.verter.conventions.kotlin-jvm") version "0.1.0"
    id("org.gamedo.verter.conventions.ktlint") version "0.1.0"
}
```

应用上述插件后，该模块将自动具备：

- Kotlin/JVM 插件（`org.jetbrains.kotlin.jvm`）
- 统一的 Java 21 toolchain 与 `jvmTarget = 21`
- 测试使用 JUnit Platform (`useJUnitPlatform()`)
- 统一的 ktlint 配置（规则集、任务等）

通常情况下，业务模块只需在 `dependencies {}` 中声明自身依赖，无需再重复写 Kotlin / JUnit / ktlint 相关的插件与任务配置。

---

## 本地开发与调试

在本仓库根目录执行：

```bash
./gradlew build
./gradlew publishToMavenLocal
```

然后在其他工程中通过 `pluginManagement.repositories { mavenLocal() }` 引入本地发布的插件版本，便于联调。

发布到 Gradle Plugin Portal 时，请使用：

```bash
./gradlew publishPlugins
```

确保已经在本机 `~/.gradle/gradle.properties` 中配置好：

```properties
gradle.publish.key=你的PluginPortalKey
gradle.publish.secret=你的PluginPortalSecret
```

---

## 版本与兼容性

- 插件本身使用 Gradle Kotlin DSL 编写，要求 Gradle 8.x 及以上版本。
- 推荐使用 Java 17 或 21 运行 Gradle，业务模块通过 toolchain 统一到 Java 21 编译。

具体兼容范围以后会在发布新的插件版本时补充到这里。

---

## License

本项目计划采用开源许可证发布。具体 License 见仓库根目录的 `LICENSE` 文件

