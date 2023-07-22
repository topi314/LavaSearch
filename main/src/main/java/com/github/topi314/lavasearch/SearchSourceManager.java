package com.github.topi314.lavasearch;

import com.github.topi314.lavasearch.protocol.SearchResult;
import com.github.topi314.lavasearch.protocol.SearchType;
import kotlin.annotations.jvm.ReadOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public interface SearchSourceManager {

	@NotNull
	String getSourceName();

	@Nullable
	SearchResult loadSearch(@NotNull String query, @NotNull @ReadOnly Set<SearchType> types);

	void shutdown();
}
