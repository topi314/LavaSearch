package com.github.topi314.lavasearch.plugin

import com.github.topi314.lavasearch.AudioSearchResult
import com.github.topi314.lavasearch.SearchManager
import com.github.topi314.lavasearch.api.SearchResultPluginInfoModifier
import com.github.topi314.lavasearch.protocol.SearchResult
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager
import dev.arbjerg.lavalink.api.AudioPluginInfoModifier
import jakarta.servlet.http.HttpServletRequest
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class SearchRestHandler(
    private val searchManager: SearchManager,
    private val playerManager: AudioPlayerManager,
    private val pluginInfoModifiers: List<AudioPluginInfoModifier>,
    private val searchResultInfoModifiers: List<SearchResultPluginInfoModifier>
) {

    companion object {
        private val log = LoggerFactory.getLogger(SearchRestHandler::class.java)
    }

    @GetMapping("/v4/loadsearch")
    fun loadSearch(
        request: HttpServletRequest?,
        @RequestParam query: String?,
        @RequestParam(required = false) types: String?
    ): ResponseEntity<SearchResult> {
        log.debug("loadSearch called with query: {}, types: {}", query, types)
        val finalTypes = if (types.isNullOrBlank()) emptySet() else types.split(""",\s*""".toRegex()).mapNotNull { AudioSearchResult.Type.fromName(it) }.toSet()
        val result = searchManager.loadSearch(query, finalTypes)
        return if (result != null) {
            ResponseEntity.ok(result.toSearchResult(playerManager, pluginInfoModifiers, searchResultInfoModifiers))
        } else ResponseEntity.notFound().build()
    }
}
