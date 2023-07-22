package com.github.topi314.lavasearch.plugin;

import com.github.topi314.lavasearch.SearchManager;
import com.github.topi314.lavasearch.protocol.SearchResult;
import com.github.topi314.lavasearch.protocol.SearchType;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class SearchRestHandler {

	private static final Logger log = LoggerFactory.getLogger(SearchRestHandler.class);

	private final SearchManager searchManager;

	public SearchRestHandler(SearchManager searchManager) {
		this.searchManager = searchManager;
		log.info("SearchRestHandler created");
	}

	@GetMapping("/v4/loadsearch")
	public ResponseEntity<SearchResult> loadSearch(HttpServletRequest request, @RequestParam String query, @RequestParam(required = false) String types) {
		log.debug("loadSearch called with query: {}, types: {}", query, types);

		Set<SearchType> finalTypes = types == null || types.isBlank() ? new HashSet<>() : Arrays.stream(types.split(",")).map(s -> SearchType.fromString(s.trim())).collect(Collectors.toSet());
		var result = searchManager.loadSearch(query, finalTypes);
		if (result != null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.notFound().build();
	}
}
