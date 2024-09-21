package com.SpringBoot.ServerRegistry.ServerRegistryBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServerRegistryBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerRegistryBootApplication.class, args);
	}

}
