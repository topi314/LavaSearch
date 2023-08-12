package com.github.topi314.lavasearch;

import kotlin.annotations.jvm.ReadOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public interface SearchSourceManager {

	@NotNull
	String getSourceName();

	@Nullable
	AudioSearchResult loadSearch(@NotNull String query, @NotNull @ReadOnly Set<AudioSearchResult.Type> types);

	void shutdown();
}
