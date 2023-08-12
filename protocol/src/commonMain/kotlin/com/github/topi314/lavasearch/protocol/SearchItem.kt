package com.github.topi314.lavasearch.protocol

import dev.arbjerg.lavalink.protocol.v4.Playlist
import dev.arbjerg.lavalink.protocol.v4.Track
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import kotlin.jvm.JvmField

@Serializable
data class SearchResult(
    val tracks: List<Track>,
    val albums: List<Playlist>,
    val artists: List<Playlist>,
    val playlists: List<Playlist>,
    val texts: List<Text>,
    val plugin: JsonObject
) {
    companion object {
        @JvmField
        val EMPTY = SearchResult(emptyList(), emptyList(), emptyList(), emptyList(), emptyList(), JsonObject(emptyMap()))
    }
}


@Serializable
data class Text(val text: String, val plugin: JsonObject)

