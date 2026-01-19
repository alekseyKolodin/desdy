import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.kotlin.compose)
}

kotlin {
    jvm("desktop")

    sourceSets {
        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)
                implementation(project(":shared"))
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "com.desdy.showcase.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "Desdy Showcase"
            packageVersion = "1.0.0"

            macOS {
                bundleID = "com.desdy.showcase"
            }

            windows {
                menuGroup = "Desdy"
                upgradeUuid = "d7e1b4a2-8c3f-4e5d-9a6b-1c2d3e4f5a6b"
            }

            linux {
                packageName = "desdy-showcase"
            }
        }
    }
}
