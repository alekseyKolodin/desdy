plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    `maven-publish`
}

android {
    namespace = "com.desdy"
    compileSdk = 36

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    // Core
    implementation(libs.androidx.core.ktx)

    // Compose BOM
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.compose.foundation)
    implementation(libs.compose.runtime)
    implementation(libs.compose.material.icons)
    implementation(libs.compose.material.icons.extended)

    // Debug
    debugImplementation(libs.compose.ui.tooling)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

// Publishing configuration
publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.github.anthropics" // Замените на ваш GitHub username
            artifactId = "desdy"
            version = "1.0.0"

            afterEvaluate {
                from(components["release"])
            }

            pom {
                name.set("Desdy Design System")
                description.set("Noble and elegant Android design system built with Jetpack Compose")
                url.set("https://github.com/anthropics/desdy") // Замените на ваш репозиторий

                licenses {
                    license {
                        name.set("Apache License 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0")
                    }
                }

                developers {
                    developer {
                        id.set("developer")
                        name.set("Developer Name")
                        email.set("developer@example.com")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/anthropics/desdy.git")
                    developerConnection.set("scm:git:ssh://github.com/anthropics/desdy.git")
                    url.set("https://github.com/anthropics/desdy")
                }
            }
        }
    }
}
