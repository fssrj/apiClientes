package br.com.cotiinformatica.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	OpenAPI customOpenApi() {

		return new OpenAPI().components(new Components())
				.info(new Info().title("API para controle de clientes - COTI Informática")
						.description("API REST desenvolvida em Spring Boot").version("v1"));
	}

}
