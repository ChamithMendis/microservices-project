package com.chamith.microservices.product.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

public class OpenAPIConfig {

    @Bean
    public OpenAPI productServiceAPI() {
        return new OpenAPI().info(new Info().title("Product Service API")
                .description("This is the rest API for the product service")
                .version("1.0")
                .license(new License().name("Apache 2.9=0")))
                .externalDocs(new ExternalDocumentation()
                        .description("You can refer to the product service wiki documentation")
                        .url("https://github.com/chamith/product-service"));
    }
}
