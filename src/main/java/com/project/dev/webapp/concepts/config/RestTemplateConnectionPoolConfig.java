package com.project.dev.webapp.concepts.config;

import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.core5.util.Timeout;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConnectionPoolConfig {

	@Bean
	RestTemplate restTemplateConnectionPool(RestTemplateBuilder builder) {

		// Create HttpClient Connection Pool with maximum TCP connection as 120 and maximum TCP/service as 30
		PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
		poolingHttpClientConnectionManager.setMaxTotal(120);
		poolingHttpClientConnectionManager.setDefaultMaxPerRoute(30);
		

		// Connection Request Timeout - how long to wait to get a connection from the connection pool.
		// Connect Timeout - Time to establish a TCP connection to the remote host.
		// Response Timeout - Time to wait for a server response after sending the request.
		RequestConfig requestConfig = RequestConfig
						.custom()
						.setConnectionRequestTimeout(Timeout.ofSeconds(300))
						.setConnectTimeout(Timeout.ofSeconds(300))
						.setResponseTimeout(Timeout.ofSeconds(300))
						.build();

		
		// Builds an **HttpClient (TCP Connection)** with the pooling and timeout configuration.
		CloseableHttpClient closeableHttpClient = HttpClientBuilder
								.create()
								.setConnectionManager(poolingHttpClientConnectionManager)
								.setDefaultRequestConfig(requestConfig)
								.build();

		
		// Wraps the custom HttpClient into a Spring-compatible ClientHttpRequestFactory.
		HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(closeableHttpClient);

		
		// Creates the RestTemplate Bean
		return new RestTemplate(httpComponentsClientHttpRequestFactory);
	}

}
