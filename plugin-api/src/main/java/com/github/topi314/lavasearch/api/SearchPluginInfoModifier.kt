package com.github.topi314.lavasearch.api

import com.github.topi314.lavasearch.result.AudioSearchResult
import com.github.topi314.lavasearch.result.AudioText
import kotlinx.serialization.json.JsonObject

interface SearchPluginInfoModifier {

    fun modifyAudioTextPluginInfo(text: AudioText): JsonObject? = null

    fun modifySearchResultPluginInfo(result: AudioSearchResult): JsonObject? = null

}
