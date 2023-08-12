package com.github.topi314.lavasearch.api

import com.github.topi314.lavasearch.AudioSearchResult
import com.github.topi314.lavasearch.AudioText
import kotlinx.serialization.json.JsonObject

interface SearchResultPluginInfoModifier {

    fun modifyAudioTextPluginInfo(text: AudioText): JsonObject? = null

    fun modifySearchResultPluginInfo(result: AudioSearchResult): JsonObject? = null

}
