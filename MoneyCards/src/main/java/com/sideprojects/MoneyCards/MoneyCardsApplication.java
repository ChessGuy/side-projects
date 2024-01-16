package com.sideprojects.MoneyCards;

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
		List<Score> scores = new ArrayList<>();
		Score score1 = new Score(1, "EJ ", 3000);
		Score score2 = new Score(2, "EJB", 2500);
		Score score3 = new Score(3, "LEB", 2000);

		scores.add(score1);
		scores.add(score2);
		scores.add(score3);

		ScoreBoard scoreBoard = new ScoreBoard(scores);

		System.out.println(scoreBoard);

		// Command Line Interface
		new MoneyCardsCLI();
	}

}
