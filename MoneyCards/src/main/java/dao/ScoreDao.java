package dao;

import model.Score;

import java.util.List;

public interface ScoreDao {

    List<Score> getScores ();

    Score getScoreById ();

    Score createScore ();

    Score updateScore ();

    int deleteLowestScore ();


}
