package com.nodamu.dogapi.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig   {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo (){
        return  new ApiInfo(
                "Dog Rest API",
                "This API returns a list of Dogs",
                "1.0",
                "github.com/nodamu/DogApi",
                new Contact("Nicholas Adamu", "github.com/nodamu", "nickadamu@gmail.com"),
                "License of API", "https://opensource.org/licenses/MIT", Collections.emptyList());
    }
}
