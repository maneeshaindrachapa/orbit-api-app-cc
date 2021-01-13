package com.cloud.orbitapi;

import com.cloud.orbitapi.exception.handler.RestTemplateResponseErrorHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.TimeZone;


@SpringBootApplication
@EntityScan(basePackages = "com.cloud.orbitapi")
@EnableJpaRepositories(basePackages = "com.cloud.orbitapi")
@ComponentScan(basePackages = "com.cloud.orbitapi")
public class OrbitApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrbitApiApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplateBuilder()
				.errorHandler(new RestTemplateResponseErrorHandler())
				.build();
	}

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getDefault());
	}
}
