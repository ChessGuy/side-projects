package com.sideprojects.MoneyCards.model;

// import java.sql.SQLOutput;
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
                "          HIGH SCORES         \n" +
                "______________________________\n";
        for (int i = 1;i <= scores.size(); i++) {
            String iString = Integer.toString(i);
            if (iString.length() <= 1) {
                iString = " " + iString;
        }
            scoreBoardString += iString + " " + scores.get(i-1).toString() + "\n";
        }
        return scoreBoardString;
    }
}
