package com.github.topi314.lavasearch.plugin;

import com.github.topi314.lavasearch.SearchManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class SearchManagerConfiguration {

	@Bean
	public SearchManager searchManagerSupplier(Collection<com.github.topi314.lavasearch.api.SearchManagerConfiguration> searchManagerConfigurations) {
		var manager = new SearchManager();

		for (var config : searchManagerConfigurations) {
			manager = config.configure(manager);
		}

		return manager;
	}

}
