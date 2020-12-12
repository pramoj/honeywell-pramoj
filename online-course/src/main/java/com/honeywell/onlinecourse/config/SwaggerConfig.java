/*
 * Copyright (C) Honeywell
 */
package com.honeywell.onlinecourse.config;

import java.util.Collections;
import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.Nullable;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private static final String SERVICE_TITLE = "online-course";
    private static final String SERVICE_DESCRIPTION = "online-course";
    private static final String APPLICATION_VERSION = "1";
    private static final String TOS_URL = "";
    private static final String CONTACT_NAME = "online-course";
    private static final String CONTACT_URL = "https://online-course.com/contact";
    private static final String CONTACT_EMAIL = "";
    private static final String APPLICATION_LICENSE = "";
    private static final String LICENSE_URL = "";

    static class DisallowV2Paths implements com.google.common.base.Predicate<String> {
        @Override
        public boolean apply(@Nullable String input) {
            return Optional.ofNullable(input).map(path -> path.startsWith("/v1")).orElse(Boolean.FALSE);
        }
    }
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                SERVICE_TITLE,
                SERVICE_DESCRIPTION,
                APPLICATION_VERSION,
                TOS_URL,
                new Contact(CONTACT_NAME, CONTACT_URL, CONTACT_EMAIL),
                APPLICATION_LICENSE,
                LICENSE_URL,
                Collections.emptyList()
        );
    }
}
