plugins {
    kotlin("multiplatform") version "1.9.0"
}

group = "com.neo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        jvmToolchain(8)
        withJava()
        testRuns.named("test") {
            executionTask.configure {
                useJUnitPlatform()
            }
        }
    }
    js {
        browser {
            commonWebpackConfig(
                Action {
                    cssSupport {
                        enabled.set(true)
                    }
                }
            )
        }
    }

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val jvmMain by getting
        val jvmTest by getting

        val jsMain by getting {
            dependencies {
                implementation(npm("base-64", "1.0.0"))
            }
        }
        val jsTest by getting

        val nativeMain by getting
        val nativeTest by getting
    }
}
