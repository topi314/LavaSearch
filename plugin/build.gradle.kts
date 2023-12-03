import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("jvm")
    id("dev.arbjerg.lavalink.gradle-plugin") version "1.0.15"
}

base {
    archivesName = "lavasearch-plugin"
}

lavalinkPlugin {
    name = "lavasearch-plugin"
    apiVersion = "4.0.0"
    serverVersion = "4.0.0"
    configurePublishing = false
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    implementation(project(":main"))
    implementation(project(":protocol"))
    implementation(project(":plugin-api"))
    compileOnly("dev.arbjerg.lavalink:Lavalink-Server:4.0.0")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            artifactId = base.archivesName.get()
        }
    }
}
