package dao;

import exception.DaoException;
import model.Score;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
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
        List<Score> scores = new ArrayList<>();
        String sql = "SELECT * FROM score";

        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
            while (rowSet.next()) {
                scores.add(mapRowToScore(rowSet));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database or server", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation", e);
        }
        return scores;
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
