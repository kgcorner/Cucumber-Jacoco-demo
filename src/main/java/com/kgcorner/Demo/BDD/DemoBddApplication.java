package com.kgcorner.Demo.BDD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoBddApplication {

	public static void main(String[] args) {
		Store.initializeLibrary();
		SpringApplication.run(DemoBddApplication.class, args);
	}
}
