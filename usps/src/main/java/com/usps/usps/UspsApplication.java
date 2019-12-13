package com.usps.usps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UspsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UspsApplication.class, args);
	}

}
