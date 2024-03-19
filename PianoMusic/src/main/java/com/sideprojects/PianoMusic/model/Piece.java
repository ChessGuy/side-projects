package com.sideprojects.PianoMusic.model;

import jakarta.validation.constraints.NotNull;

public class Piece {

    @NotNull
    private int pieceId;
    private int collectionId;
    @NotNull
    private String pieceName;
    private int publishedYear;

    public Piece () {}

    public Piece(int pieceId, int collectionId, String pieceName, int publishedYear) {
        this.pieceId = pieceId;
        this.collectionId = collectionId;
        this.pieceName = pieceName;
        this.publishedYear = publishedYear;
    }
    public int getPieceId() {
        return pieceId;
    }

    public void setPieceId(int pieceId) {
        this.pieceId = pieceId;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public String getPieceName() {
        return pieceName;
    }

    public void setPieceName(String pieceName) {
        this.pieceName = pieceName;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }
}
