package com.github.vlsergey.exampleapp;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.ForwardedHeaderFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.github.vlsergey.exampleapp.data.utils.CustomRepositoryImpl;

@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableJpaRepositories(basePackages = { "com.github.vlsergey.exampleapp.data" }, //
		repositoryBaseClass = CustomRepositoryImpl.class)
@EnableWebMvc
@EntityScan("com.github.vlsergey.exampleapp.data")
@SpringBootApplication
public class DefaultConfiguration {

	@Bean
	public ForwardedHeaderFilter forwardedHeaderFilter() {
		return new ForwardedHeaderFilter();
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
