package com.dianwoyin.price.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 配置Swagger的Docket的bean实例
     *
     * @return
     */
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.dianwoyin.price.controller")).build();
    }

    public ApiInfo apiInfo() {
        Contact contact = new Contact("dongchunxu", "", "13952589089@163.com");
        return new ApiInfo("报价接口", "for mini program", "v1.0", "",
                contact,
                "",
                "",
                new ArrayList());

    }
}