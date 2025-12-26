package com.assettracking.demo.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .components(new Components()
                .addSecuritySchemes("bearer-key",  // Name of the security scheme
                    new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")))  // Defines Bearer token with JWT format
            .info(new Info()
                .title("Asset Tracking API")
                .version("1.0")
                .description("API for managing assets with JWT authentication"))
            .addSecurityItem(new SecurityRequirement().addList("bearer-key"));  // Applies globally to all endpoints
    }
}