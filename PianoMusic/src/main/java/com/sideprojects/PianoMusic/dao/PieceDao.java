package com.sideprojects.PianoMusic.dao;

import com.sideprojects.PianoMusic.model.Piece;

import java.util.List;

public interface PieceDao {

    List<Piece> getPieces ();

    Piece getPieceById (int pieceId);

    List<Piece> getPiecesByName (String searchTerm);

    Piece addPiece (Piece piece);

    Piece updatePiece (Piece piece);

    int deletePieceById (int pieceId);




}
