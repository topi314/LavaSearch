package com.github.topi314.lavasearch.api;

import com.github.topi314.lavasearch.SearchManager;
import org.jetbrains.annotations.NotNull;

public interface SearchManagerConfiguration {

	@NotNull
	SearchManager configure(@NotNull SearchManager manager);

}
