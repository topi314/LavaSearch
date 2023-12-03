plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

base {
    archivesName = "lavasearch-protocol"
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    js(IR) {
        nodejs()
    }

    publishing {
        publications {
            withType<MavenPublication> {
                artifactId = "lavasearch-$artifactId"
            }
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
                implementation("dev.arbjerg.lavalink:protocol:4.0.0")
            }
        }
    }
}
