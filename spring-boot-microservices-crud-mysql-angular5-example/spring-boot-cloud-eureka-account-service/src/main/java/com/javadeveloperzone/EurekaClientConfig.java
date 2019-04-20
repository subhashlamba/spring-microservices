package com.javadeveloperzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by JavaDeveloperZone on 19-07-2017.
 */

@SpringBootApplication
@EnableEurekaClient         // To enable eureka client
public class EurekaClientConfig {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(EurekaClientConfig.class, args);            // it wil start application
    }
}
