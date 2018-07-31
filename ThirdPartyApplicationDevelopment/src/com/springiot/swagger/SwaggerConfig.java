/**
 * 
 */
package com.springiot.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author mandeepsingh
 *
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter {

	/**
	 * 
	 * @return
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.springiot.controllers")).build().apiInfo(apiInfo())
				.useDefaultResponseMessages(false);
	}

	/**
	 * 
	 * @return
	 */
	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("ThirdPartyApplicatin REST API",
				"The ThirdParty Application Api Basically a client end Api which client calls to get data in their respect",
				"1.0.0", "Teramatrix.corp", "Mandeep Singh", "API License", "API License URL");
		return apiInfo;
	}

}
