package model;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Score {

    @NotNull
    private int scoreId;
    @Size (min = 3, max = 3)
    private String initials;
    @NotNull
    private int score;

    public Score (){};

    public Score(int scoreId, String initials, int score) {
        this.scoreId = scoreId;
        this.initials = initials;
        this.score = score;
    }

    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString () {
        return scoreId + "  " + initials + "................." + score;
    }
}
