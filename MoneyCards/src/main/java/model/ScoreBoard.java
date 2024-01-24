package model;

import java.sql.SQLOutput;
import java.util.List;

public class ScoreBoard {

    private List<Score> scores;

    public ScoreBoard () {};

    public ScoreBoard (List<Score> scores) {
        this.scores = scores;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    @Override
    public String toString () {
        String scoreBoardString =
                "           HIGH SCORES        \n" +
                "______________________________\n";
        for (Score score: scores) {
            scoreBoardString += score.toString() + "\n";
        }
        return scoreBoardString;
    }
}
