package com.andre.subscriptions.api.documentation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger configuration bean.
 * @author nestis
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
    public Docket api() {
		ApiInfo DEFAULT_API_INFO = new ApiInfoBuilder()
				.description("Exposes endpoints to manipulate users subscriptions")
				.title("Subscriptions API microservice")
				.version("0.0.1-SNAPSHOT").build();
		
        return new Docket(DocumentationType.SWAGGER_2)  
          .apiInfo(DEFAULT_API_INFO)
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.andre.subscriptions.api"))
          .paths(PathSelectors.any())
          .build();                  
    }
}
