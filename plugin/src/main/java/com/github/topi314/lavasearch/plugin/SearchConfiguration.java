package com.github.topi314.lavasearch.plugin;

import com.github.topi314.lavasearch.AudioSearchManager;
import com.github.topi314.lavasearch.api.SearchManagerConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

@Configuration
public class SearchConfiguration {

	@Bean
	public AudioSearchManager audioSearchManagerSupplier(Collection<SearchManagerConfiguration> searchManagerConfigurations) {
		var manager = new AudioSearchManager();

		for (var config : searchManagerConfigurations) {
			manager = config.configure(manager);
		}

		return manager;
	}

}
