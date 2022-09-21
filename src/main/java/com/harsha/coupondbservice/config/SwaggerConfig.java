package com.harsha.coupondbservice.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("CouponDBService").apiInfo(apiInfo()).select()
				.paths(regex("/coupondb/addcoupon")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("CouponDBService API")
				.description("CouponDBService API reference for developers").termsOfServiceUrl("")
				.license("CouponDBService License").licenseUrl("Harsha").version("1.0").build();
	}
}
