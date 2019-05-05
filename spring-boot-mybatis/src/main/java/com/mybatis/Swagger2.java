package com.mybatis;

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
 * @author BrokenColor
 * @data 2018年5月10日
 */

// 通过@Configuration注解，让Spring来加载该类配置。
// 再通过@EnableSwagger2注解来启用Swagger2。
@Configuration
@EnableSwagger2
public class Swagger2 {
	
	//通过createRestApi函数创建Docket的Bean
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.select()//select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现
				.apis(RequestHandlerSelectors.basePackage("com.mybatis.controller"))//指定扫描的包路径
				.paths(PathSelectors.any()).build();
	}

	//apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）。
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Spring Boot中使用Swagger2构建RESTful APIs")
				.description("Spring Boot与Swagger2")
				.termsOfServiceUrl("http://www.google.com.cn/")
				.contact("BrokenColor")
				.version("1.0").build();
	}
//	ApiInfo apiInfo = new ApiInfo("title", "description", "version", "termsOfServiceUrl",
//			"contact", "license", "licenseUrl");
}
