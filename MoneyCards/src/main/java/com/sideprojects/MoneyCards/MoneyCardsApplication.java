package com.sideprojects.MoneyCards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import view.MoneyCardsCLI;

@SpringBootApplication
public class MoneyCardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoneyCardsApplication.class, args);

		// Command Line Interface
		new MoneyCardsCLI();
	}

}
