package dao;

import model.Score;

import java.util.List;

public interface ScoreDao {

    List<Score> getScores ();

    Score getScoreById (int scoreId);

    Score createScore (Score score);

    int deleteLowestScore ();

}
