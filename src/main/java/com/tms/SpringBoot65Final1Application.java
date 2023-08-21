package com.tms;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@OpenAPIDefinition(
        info = @Info(
                title = "Group 65 project",
                description = "This is pet project",
                contact = @Contact(
                        name = "Liubenkov Denis",
                        email = "denisliubenkov@yandex.by",
                        url = "@liubenkovdenis"

                )
        )
)
@SpringBootApplication
public class SpringBoot65Final1Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot65Final1Application.class);
    }
}