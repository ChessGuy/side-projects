package com.sideprojects.MoneyCards;

import controller.ScoreBoardController;
import dao.ScoreDao;
import model.Score;
import model.ScoreBoard;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import view.MoneyCardsCLI;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MoneyCardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoneyCardsApplication.class, args);

		// Command Line Interface
		new MoneyCardsCLI();
	}

}
