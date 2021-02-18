package org.susi.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.integration.http.config.EnableIntegrationGraphController;


@EnableDiscoveryClient
@SpringBootApplication
@EnableIntegrationGraphController(allowedOrigins = "*")
public class EurekaClientApplication {

	public EurekaClientApplication() {
		System.out.println("      ____           ____   _       \n     / ___'  _   _  / ___' (_)\n     \\___ | | | | | \\___ | | |\n      ___)| | |_| |  ___)| | |\n     |____| |_____| |____| |_| ");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
}

