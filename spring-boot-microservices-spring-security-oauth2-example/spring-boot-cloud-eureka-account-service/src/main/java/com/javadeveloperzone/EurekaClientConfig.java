package com.javadeveloperzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Created by JavaDeveloperZone on 19-07-2017.
 */

@SpringBootApplication
@ComponentScan // Using a root package also allows the @ComponentScan annotation to be used without needing to specify a basePackage attribute
@EnableEurekaClient         // To enable eureka client
@EnableResourceServer
public class EurekaClientConfig {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(EurekaClientConfig.class, args);            // it wil start application
    }
}
