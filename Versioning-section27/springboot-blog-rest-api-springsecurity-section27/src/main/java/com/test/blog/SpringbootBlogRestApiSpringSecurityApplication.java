package com.test.blog;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot Blog REST APIs",
                version = "v1.0",
                description = "Spring Boot Blog App Rest API Documentation with Spring Boot and Spring Security",
                contact = @Contact(
                        name = "Pradeep Kumar Kumar",
                        email = "k.pradeep@gmail.com",
                        url = "https://www.linkedin.com/in/pradeep-kumar-4248/"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Spring Boot Blog REST API Documentation",
                url = "https://github.com/pradeep491/BuildRestApis-javaguides"
        )
)
public class SpringbootBlogRestApiSpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBlogRestApiSpringSecurityApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
