package com.liuning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(
                        "com.liuning.controller"))
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact(
                "LiuNing",
                "https://springfox.github.io/springfox/",
                "liuning@qq.com"
        );

        return new ApiInfoBuilder()
                .title("Swagger自动化接口文档")
                .description("open-api接口")
                .contact(contact)
                .version("1.1.0")
                .build();
    }
}
