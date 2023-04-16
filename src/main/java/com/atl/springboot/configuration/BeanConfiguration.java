package com.atl.lesson34.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
public class BeanConfiguration {

    @Bean

//    @Profile("dev")
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Student API")
                        .description("Student API Documentation")
                        .termsOfService("Terms")
                        .license(new License()
                                .name("Student Service"))
                        .version("1.0.0"));
    }
}
