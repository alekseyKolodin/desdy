plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.android.library)
    `maven-publish`
}

kotlin {
    jvmToolchain(21)

    androidTarget {
        publishLibraryVariants("release")
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "DesdyDesign"
            isStatic = true
        }
    }

    jvm("desktop")

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
        }

        androidMain.dependencies {
            implementation(libs.androidx.core.ktx)
        }

        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.common)
            }
        }
    }
}

android {
    namespace = "com.desdy"
    compileSdk = 36

    defaultConfig {
        minSdk = 24
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

// Publishing configuration for KMP
// Kotlin Multiplatform automatically creates publications for each target
group = "io.github.alekseykolodin"
version = "2.0.5"

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/alekseyKolodin/desdy")
            credentials {
                username = System.getenv("GITHUB_ACTOR") ?: project.findProperty("gpr.user") as String? ?: ""
                password = System.getenv("GITHUB_TOKEN") ?: project.findProperty("gpr.token") as String? ?: ""
            }
        }
    }

    publications.withType<MavenPublication> {
        pom {
            name.set("Desdy Design System")
            description.set("Kotlin Multiplatform design system for Android, iOS, and Desktop")
            url.set("https://github.com/alekseyKolodin/desdy")

            licenses {
                license {
                    name.set("Apache License 2.0")
                    url.set("https://www.apache.org/licenses/LICENSE-2.0")
                }
            }

            developers {
                developer {
                    id.set("Aleksey")
                    name.set("Aleksey Kolodin")
                    email.set("aleksey.kolodin56@gmail.com")
                }
            }

            scm {
                connection.set("scm:git:git://github.com/alekseyKolodin/desdy.git")
                developerConnection.set("scm:git:ssh://github.com/alekseyKolodin/desdy.git")
                url.set("https://github.com/alekseyKolodin/desdy")
            }
        }
    }
}
