package com.github.topi314.lavasearch.api

import com.github.topi314.lavasearch.AudioSearchManager

interface SearchManagerConfiguration {
    fun configure(manager: AudioSearchManager): AudioSearchManager
}
