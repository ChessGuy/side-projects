package com.sideprojects.MoneyCards.dao;

import java.util.List;

import com.sideprojects.MoneyCards.model.Score;

public interface ScoreDao {

    List<Score> getScores ();

    Score getScoreById (int scoreId);

    Score createScore (Score score);

    Score getLowestScore ();

    int deleteLowestScore ();

}
