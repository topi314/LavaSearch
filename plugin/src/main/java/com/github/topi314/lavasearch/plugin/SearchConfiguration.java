package com.github.topi314.lavasearch.plugin;

import com.github.topi314.lavasearch.SearchManager;
import com.github.topi314.lavasearch.api.SearchManagerConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

@Configuration
public class SearchConfiguration {

	@Bean
	public SearchManager audioSearchManagerSupplier(Collection<SearchManagerConfiguration> searchManagerConfigurations) {
		var manager = new SearchManager();

		for (var config : searchManagerConfigurations) {
			manager = config.configure(manager);
		}

		return manager;
	}

}
