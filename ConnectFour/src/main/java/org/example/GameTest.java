package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

    Game testGame = null;
    @Before
    public void setUpTestGame () {
        testGame = new Game(new int [][] {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        });;
    }

    @Test
    public void check_piece_placement () {
        //Arrange
        int [][] boardAfterPieceInFirstCol = new int[][] {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0}
        };
        //Act
        testGame.setPlayer1Turn(true);
        testGame.playPiece(1);
        //Assert
        Assert.assertEquals("Piece 1 should be present in column one of the board", testGame.getBoard(), boardAfterPieceInFirstCol);
    }

}
