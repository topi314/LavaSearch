plugins {
    kotlin("jvm")
    id("dev.arbjerg.lavalink.gradle-plugin") version "1.0.10"
}

base {
    archivesName = "lavasearch-plugin"
}

lavalinkPlugin {
    name = "lavasearch-plugin"
    apiVersion = "4.0.0-beta.3"
    serverVersion = "4.0.0-beta.3"
}

java {

}

dependencies {
    implementation(project(":main"))
    implementation(project(":protocol"))
    implementation(project(":plugin-api"))
    compileOnly("dev.arbjerg.lavalink:Lavalink-Server:4.0.0-beta.3")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            artifactId = base.archivesName.get()
        }
    }
}
