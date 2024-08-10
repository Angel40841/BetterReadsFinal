package com.example.betterreads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class BetterReadsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetterReadsApplication.class, args);
	}

}
 