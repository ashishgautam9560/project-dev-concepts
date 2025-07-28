package com.project.dev.webapp.concepts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	@Bean
	RestTemplate restTemplate() {

		SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		simpleClientHttpRequestFactory.setConnectTimeout(5000); // in milliseconds
		simpleClientHttpRequestFactory.setReadTimeout(10000); // in milliseconds

		return new RestTemplate(simpleClientHttpRequestFactory);
	}

}
