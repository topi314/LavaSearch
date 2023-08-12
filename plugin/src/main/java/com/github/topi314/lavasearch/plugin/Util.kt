package com.github.topi314.lavasearch.plugin

import com.github.topi314.lavasearch.result.AudioSearchResult
import com.github.topi314.lavasearch.result.AudioText
import com.github.topi314.lavasearch.api.SearchPluginInfoModifier
import com.github.topi314.lavasearch.protocol.SearchResult
import com.github.topi314.lavasearch.protocol.Text
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager
import dev.arbjerg.lavalink.api.AudioPluginInfoModifier
import dev.arbjerg.lavalink.protocol.v4.Playlist
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import lavalink.server.util.toPlaylistInfo
import lavalink.server.util.toPluginInfo
import lavalink.server.util.toTrack

fun AudioSearchResult.toSearchResult(
    audioPlayerManager: AudioPlayerManager,
    pluginInfoModifiers: List<AudioPluginInfoModifier>,
    searchResultInfoModifiers: List<SearchPluginInfoModifier>
): SearchResult {
    val tracks = tracks.map { it.toTrack(audioPlayerManager, pluginInfoModifiers) }
    val playlists = playlists.map { Playlist(it.toPlaylistInfo(), it.toPluginInfo(pluginInfoModifiers), emptyList()) }
    val albums = albums.map { Playlist(it.toPlaylistInfo(), it.toPluginInfo(pluginInfoModifiers), emptyList()) }
    val artists = artists.map { Playlist(it.toPlaylistInfo(), it.toPluginInfo(pluginInfoModifiers), emptyList()) }
    val texts = texts.map { it.toText(searchResultInfoModifiers) }

    val plugin = searchResultInfoModifiers.fold(JsonObject(emptyMap())) { acc, it ->
        val jsonObject = it.modifySearchResultPluginInfo(this) ?: JsonObject(emptyMap())
        acc + jsonObject
    }

    return SearchResult(tracks, albums, artists, playlists, texts, plugin)
}

fun AudioText.toText(searchResultInfoModifiers: List<SearchPluginInfoModifier>): Text {
    val plugin = searchResultInfoModifiers.fold(JsonObject(emptyMap())) { acc, it ->
        val jsonObject = it.modifyAudioTextPluginInfo(this) ?: JsonObject(emptyMap())
        acc + jsonObject
    }

    return Text(text, plugin)
}


private operator fun JsonObject.plus(other: JsonObject) = JsonObject(this + (other as Map<String, JsonElement>))
