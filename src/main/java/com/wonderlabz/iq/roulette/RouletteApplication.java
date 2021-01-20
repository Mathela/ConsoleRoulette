package com.wonderlabz.iq.roulette;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RouletteApplication {

	public static void main(String[] args) {
		SpringApplication.run(RouletteApplication.class, args);
	}

}
