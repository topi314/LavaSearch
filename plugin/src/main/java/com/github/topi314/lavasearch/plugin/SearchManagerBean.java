package com.github.topi314.lavasearch.plugin;

import com.github.topi314.lavasearch.SearchManager;
import com.github.topi314.lavasearch.api.SearchManagerConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

public class SearchManagerBean {

	@Bean
	public SearchManager SearchManagerSupplier(Collection<SearchManagerConfiguration> searchManagerConfigurations) {
		var manager = new SearchManager();

		for (var config : searchManagerConfigurations) {
			manager = config.configure(manager);
		}

		return manager;
	}
}
