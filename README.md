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

LavaSearch adds a new endpoint to Lavalink, `GET` `/v4/loadsearch`. This endpoint is used to search for tracks, albums,
artists, playlists & text.

The endpoint accepts the following query parameters:

| Parameter | Type   | Description                                                                                     |
|-----------|--------|-------------------------------------------------------------------------------------------------|
| query     | string | The search query                                                                                |
| types     | string | The types to search for, can be one or more of `track`, `album`, `artist`, `playlist` or `text` |

The endpoint returns a JSON object with the following structure:

> [!Note]
> The tracks field of playlists are always empty

| Field     | Type                                                                                                                             | Description                                                     |
|-----------|----------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------|
| tracks    | array of [Track](https://github.com/lavalink-devs/Lavalink/blob/master/IMPLEMENTATION.md#track) objects                          | An array of tracks, only present if `track` is in `types`       |
| albums    | array of [Playlist](https://github.com/lavalink-devs/Lavalink/blob/master/IMPLEMENTATION.md#load-result-data---playlist) objects | An array of albums, only present if `album` is in `types`       |
| artists   | array of [Playlist](https://github.com/lavalink-devs/Lavalink/blob/master/IMPLEMENTATION.md#load-result-data---playlist) objects | An array of artists, only present if `artist` is in `types`     |
| playlists | array of [Playlist](https://github.com/lavalink-devs/Lavalink/blob/master/IMPLEMENTATION.md#load-result-data---playlist) objects | An array of playlists, only present if `playlist` is in `types` |
| texts     | array of [Text](#text-object) objects                                                                                            | An array of text results, only present if `text` is in `types`  |
| plugin    | object                                                                                                                           | Addition result data provided by plugins                        |

<details>
<summary>Example Payload</summary>

```json
{
  "tracks": [
    {
      "encoded": "QAAB/gMAB0FuaW1hbHMACkFyY2hpdGVjdHMAAAAAAAO5IAAKMTA5MDUzODA4MgABACNodHRwczovL2RlZXplci5jb20vdHJhY2svMTA5MDUzODA4MgEAAAAAAAAAAAA==",
      "info": {
        "identifier": "1090538082",
        "isSeekable": true,
        "author": "Architects",
        "length": 244000,
        "isStream": false,
        "position": 0,
        "title": "Animals",
        "uri": "https://deezer.com/track/1090538082",
        "sourceName": "deezer",
        "artworkUrl": "https://e-cdns-images.dzcdn.net/images/cover/f63fc26eda9ed39f84c1a533e2716f46/1000x1000-000000-80-0-0.jpg",
        "isrc": null
      },
      "pluginInfo": {}
    }
  ],
  "albums": [
    {
      "info": {
        "name": "For Those That Wish To Exist",
        "selectedTrack": -1
      },
      "pluginInfo": {},
      "tracks": []
    }
  ],
  "artists": [
    {
      "info": {
        "name": "Architects's Top Tracks",
        "selectedTrack": -1
      },
      "pluginInfo": {},
      "tracks": []
    }
  ],
  "playlists": [
    {
      "info": {
        "name": "100% Architects",
        "selectedTrack": -1
      },
      "pluginInfo": {},
      "tracks": []
    }
  ],
  "texts": [
    {
      "text": "Architects",
      "plugin": {}
    }
  ],
  "plugin": {}
}
```

</details>

If no results are found the endpoint returns a http status code of `404`

### Text Object

| Field  | Type   | Description                              |
|--------|--------|------------------------------------------|
| text   | string | The title of the text result             |
| plugin | object | Addition result data provided by plugins |

