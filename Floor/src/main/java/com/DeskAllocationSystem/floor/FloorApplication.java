package com.DeskAllocationSystem.floor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FloorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FloorApplication.class, args);
	}

}
