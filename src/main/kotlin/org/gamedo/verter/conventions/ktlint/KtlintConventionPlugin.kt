package org.gamedo.verter.conventions.ktlint

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jlleitschuh.gradle.ktlint.KtlintExtension

class KtlintConventionPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit =
        with(target) {
            pluginManager.apply("org.jlleitschuh.gradle.ktlint")

            extensions.configure<KtlintExtension>("ktlint") {
                verbose.set(false)
                android.set(false)
                outputToConsole.set(true)
                filter {
                    exclude("**/build/**")
                }
            }
        }
}
