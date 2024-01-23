package dao;

import model.Score;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public class JdbcScoreDao implements ScoreDao{

    JdbcTemplate jdbcTemplate;

    public JdbcScoreDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Score mapRowToScore(SqlRowSet rowSet) {
        Score score = new Score();
        score.setScoreId(rowSet.getInt("score_id"));
        score.setInitials(rowSet.getString("initials"));
        score.setScore(rowSet.getInt("score"));
        return score;
    }

    @Override
    public List<Score> getScores() {
        return null;
    }

    @Override
    public Score getScoreById() {
        return null;
    }

    @Override
    public Score createScore() {
        return null;
    }

    @Override
    public Score updateScore() {
        return null;
    }

    @Override
    public int deleteLowestScore() {
        return 0;
    }
}
