plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kmp.library)
    `maven-publish`
}

group = "org.connecttag.libs.kotlin"
version = "1.0.6"

kotlin {
    jvmToolchain(21)

    android {
        namespace = "org.connecttag.lib.formatter"
        compileSdk = 37
        minSdk = 24
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)
        }
    }

    jvm {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)
        }
    }

    sourceSets {
        commonMain.dependencies {
            api("org.jetbrains.kotlinx:kotlinx-datetime:0.6.1")
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

publishing {
    publications.withType<MavenPublication> {
        pom {
            name.set("ConnectTag Formatter Kit (KMP)")
            description.set("Lightweight formatting utilities for dates, file sizes, network throughput, bitrates, and packet counters")
            url.set("https://github.com/connecttag/formatter-kit")
            licenses {
                license {
                    name.set("The Apache License, Version 2.0")
                    url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                }
            }
            developers {
                developer {
                    id.set("connecttagye")
                    name.set("Connect Tag")
                    email.set("connecttagye@gmail.com")
                }
            }
            scm {
                connection.set("scm:git:https://github.com/connecttag/formatter-kit.git")
                developerConnection.set("scm:git:ssh://git@github.com:connecttag/formatter-kit.git")
                url.set("https://github.com/connecttag/formatter-kit/tree/main")
            }
        }
    }
}
