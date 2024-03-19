package com.sideprojects.PianoMusic.dao;

import com.sideprojects.PianoMusic.model.Piece;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcPieceDao implements PieceDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPieceDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Piece mapRowToPiece(SqlRowSet rowSet) {
        Piece piece = new Piece();
        piece.setPieceId(rowSet.getInt("piece_id"));
        piece.setCollectionId(rowSet.getInt("collection_id"));
        piece.setPieceName(rowSet.getString("piece_name"));
        piece.setPublishedYear(rowSet.getInt("published_year"));
        return piece;
    }
    @Override
    public List<Piece> getPieces() {
        return null;
    }

    @Override
    public Piece getPieceById(int pieceId) {
        return null;
    }

    @Override
    public List<Piece> getPiecesByName(String searchTerm) {
        return null;
    }

    @Override
    public Piece addPiece(Piece piece) {
        return null;
    }

    @Override
    public Piece updatePiece(Piece piece) {
        return null;
    }

    @Override
    public int deletePieceById(int pieceId) {
        return 0;
    }
}
