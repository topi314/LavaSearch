package com.github.topi314.lavasearch.api

import com.github.topi314.lavasearch.SearchManager

interface SearchManagerConfiguration {
    fun configure(manager: SearchManager): SearchManager
}
