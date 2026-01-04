package com.project.dev.webapp.concepts.config;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class DbQueriesConfiguration {

	@Bean(name = "queriesXml")
	PropertiesFactoryBean propertiesFactoryBean(ResourceLoader resourceLoader) {
		Resource[] resources = null;
		try {
			resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader)
					.getResources("classpath*:**/queries.xml");
		} catch (IOException e) {
			log.error("Exception while reading queries file: {}", e.getMessage());
		}
		PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
		propertiesFactoryBean.setFileEncoding(UTF_8.name());
		propertiesFactoryBean.setLocations(resources);
		return propertiesFactoryBean;
	}

}
