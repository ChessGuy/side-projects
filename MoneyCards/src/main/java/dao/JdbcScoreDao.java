package dao;

import exception.DaoException;
import model.Score;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcScoreDao implements ScoreDao{

    JdbcTemplate jdbcTemplate;

    public JdbcScoreDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

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
        String sql = "SELECT * FROM score ORDER BY score DESC LIMIT 10";

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
    public Score getScoreById(int scoreId) {
        Score score = null;

        String sql = "SELECT * FROM score WHERE score_id = ?";

        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, scoreId);
            if (rowSet.next()) {
                score = mapRowToScore(rowSet);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database or server", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation", e);
        }

        return score;
    }

    @Override
    public Score createScore(Score score) {
        int newId;

        String sql = "INSERT INTO public.score(initials, score) " +
                "VALUES (?, ?) RETURNING score_id;";

        try {
            newId = jdbcTemplate.queryForObject(sql, int.class, score.getInitials(),
                    score.getScore());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database or server", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation", e);
        }
        return getScoreById(newId);

    }

    @Override
    public Score getLowestScore() {
        Score score = null;

        String sql = "SELECT * FROM score " +
                "WHERE score = (SELECT MIN (score) FROM score)";

        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
            if (rowSet.next()) {
                score = mapRowToScore(rowSet);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database or server", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation", e);
        }

        return score;
    }


    @Override
    public int deleteLowestScore() {
        String sql = "DELETE FROM score " +
                "WHERE score = (SELECT MIN (score) FROM score);";

        try {
            return jdbcTemplate.update(sql);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }
}
