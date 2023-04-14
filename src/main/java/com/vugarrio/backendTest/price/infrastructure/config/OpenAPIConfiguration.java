package com.vugarrio.backendTest.price.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenApiConfiguration configuration.
 */
@Configuration
public class OpenAPIConfiguration {
    @Bean
    public OpenAPI customOpenAPI(@Value("${info.app.version}") String appVersion) {
        return new OpenAPI()

                        .info(new Info()
                        .title("Test backend service REST API")
                        .description("API documentation for price-service")
                        .version(appVersion)
                );
    }
}
