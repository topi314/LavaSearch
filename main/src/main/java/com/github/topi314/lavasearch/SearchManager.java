package com.github.topi314.lavasearch;

import com.github.topi314.lavasearch.result.AudioSearchResult;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SearchManager {

	private final List<AudioSearchManager> searchManagers;

	public SearchManager() {
		this.searchManagers = new ArrayList<>();
	}

	public void registerSearchManager(AudioSearchManager sourceManager) {
		searchManagers.add(sourceManager);
	}

	@Nullable
	public <T extends AudioSearchManager> T search(Class<T> klass) {
		for (var sourceManager : searchManagers) {
			if (klass.isAssignableFrom(sourceManager.getClass())) {
				return klass.cast(sourceManager);
			}
		}

		return null;
	}

	public List<AudioSearchManager> getSearchManagers() {
		return this.searchManagers;
	}

	public void shutdown() {
		for (var sourceManager : this.searchManagers) {
			sourceManager.shutdown();
		}
	}

	@Nullable
	public AudioSearchResult loadSearch(String query, Set<AudioSearchResult.Type> types) throws IllegalStateException {
		if (this.searchManagers.isEmpty()){
			throw new IllegalStateException("No search source registered");
		}
		for (var sourceManager : this.searchManagers) {
			var searchResults = sourceManager.loadSearch(query, types);
			if (searchResults != null) {
				return searchResults;
			}
		}
		return null;
	}

}
