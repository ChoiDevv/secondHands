package com.shop.secondHands;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = {"com.shop.secondHands"})
public class SecondHandsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondHandsApplication.class, args);
	}

}
