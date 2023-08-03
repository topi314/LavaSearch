# LavaSearch

LavaSearch is an advanced search module for [Lavaplayer](https://github.com/sedmelluq/lavaplayer) and [Lavalink](https://github.com/lavalink-devs/Lavalink).
It returns a better search result than the default search support of Lavaplayer/Lavalink.

You can use this module with Lavaplayer or as a plugin for Lavalink v4 beta 3 or higher. Other plugins can link into this module to provide additional search sources.

<details>
<summary>Table of Contents</summary>

* [Supported Sources](#supported-sources)
* [Lavaplayer Usage](#lavaplayer-usage)
  * [Using in Gradle:](#using-in-gradle)
  * [Using in Maven:](#using-in-maven)
  * [Usage](#usage)
* [Lavalink Usage](#lavalink-usage)
</details>

## Supported Sources

* [LavaSrc](https://github.com/topi314/LavaSrc) (YouTube, YouTubeMusic, Deezer, Spotify, AppleMusic)

*Add your own*

## Lavaplayer Usage
Replace x.y.z with the latest version number

Snapshot builds are available in https://maven.topi.wtf/snapshots with the short commit hash as the version

### Using in Gradle:

<details>
<summary>Gradle</summary>

```gradle
repositories {
  maven {
    url "https://maven.topi.wtf/releases"
  }
}

dependencies {
  implementation "com.github.topi314.lavasearch:lavasearch:x.y.z"
}
```
</details>

### Using in Maven:

<details>
<summary>Maven</summary>

```xml
<repositories>
  <repository>
    <url>https://maven.topi.wtf/releases</url>
  </repository>
</repositories>

<dependencies>
  <dependency>
    <groupId>com.github.topi314.lavasearch</groupId>
    <artifactId>lavasearch</artifactId>
    <version>x.y.z</version>
  </dependency>
</dependencies>
```
</details>

### Usage

// TODO

## Lavalink Usage

This plugin requires Lavalink `v4` or greater

To install this plugin either download the latest release and place it into your `plugins` folder or add the following into your `application.yml`

> **Note**
> For a full `application.yml` example see [here](application.yml.example)

Replace x.y.z with the latest version number
```yaml
lavalink:
  plugins:
    - dependency: "com.github.topi314.lavasearch:lavasearch-plugin:x.y.z"
      repository: "https://maven.topi.wtf/releases"
```

Snapshot builds are available in https://maven.topi.wtf/snapshots with the short commit hash as the version
