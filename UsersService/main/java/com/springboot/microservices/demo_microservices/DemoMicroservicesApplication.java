package com.springboot.microservices.demo_microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient // Ensure that this annotation is included if you are using Eureka or another discovery server
public class DemoMicroservicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoMicroservicesApplication.class, args);
    }

   
}
