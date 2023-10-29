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

    //Piece placement tests
    @Test
    public void check_piece_placement_first_col () {
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

    @Test
    public void check_piece_placement_last_col () {
        //Arrange
        int [][] boardAfterPieceInLastCol = new int[][] {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1}
        };
        //Act
        testGame.setPlayer1Turn(true);
        testGame.playPiece(7);
        //Assert
        Assert.assertEquals("Piece 1 should be present in column seven of the board", testGame.getBoard(), boardAfterPieceInLastCol);
    }

    //Horizontal win tests
    @Test
    public void check_first_col_horizontal_win_lower_left_corner () {
        //Arrange
        int [][] board = new int[][] {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0}
        };

        //Act
        testGame.setBoard(board);
        testGame.setPlayer1Turn(true);
        testGame.checkForGameOver();

        //Assert
        Assert.assertTrue("First column horizontal lower left corner win condition does not end the game", testGame.isGameOver());
    }

    @Test
    public void check_last_col_horizontal_win_upper_left_corner () {
        //Arrange
        int [][] board = new int[][] {
                {1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        //Act
        testGame.setBoard(board);
        testGame.setPlayer1Turn(true);
        testGame.checkForGameOver();

        //Assert
        Assert.assertTrue("Last column horizontal upper left corner win condition does not end the game", testGame.isGameOver());
    }
    @Test
    public void check_last_col_horizontal_win_upper_right_corner () {
        //Arrange
        int [][] board = new int[][] {
                {0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        //Act
        testGame.setBoard(board);
        testGame.setPlayer1Turn(true);
        testGame.checkForGameOver();

        //Assert
        Assert.assertTrue("Last column horizontal upper right corner win condition does not end the game", testGame.isGameOver());
    }
    @Test
    public void check_last_col_horizontal_win_lower_right_corner () {
        //Arrange
        int [][] board = new int[][] {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 1}
        };

        //Act
        testGame.setBoard(board);
        testGame.setPlayer1Turn(true);
        testGame.checkForGameOver();

        //Assert
        Assert.assertTrue("Last column horizontal lower right corner win condition does not end the game", testGame.isGameOver());
    }
    //Vertical win tests

    @Test
    public void check_first_col_vertical_win_lower_left_corner () {
        //Arrange
        int [][] board = new int[][] {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0}
        };

        //Act
        testGame.setBoard(board);
        testGame.setPlayer1Turn(true);
        testGame.checkForGameOver();

        //Assert
        Assert.assertTrue("First column vertical lower left corner win condition does not end the game", testGame.isGameOver());
    }
    @Test
    public void check_first_col_vertical_win_upper_left_corner () {
        //Arrange
        int [][] board = new int[][] {
                {1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        //Act
        testGame.setBoard(board);
        testGame.setPlayer1Turn(true);
        testGame.checkForGameOver();

        //Assert
        Assert.assertTrue("First column vertical upper left corner win condition does not end the game", testGame.isGameOver());
    }
    @Test
    public void check_last_col_vertical_win_upper_right_corner () {
        //Arrange
        int [][] board = new int[][] {
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        //Act
        testGame.setBoard(board);
        testGame.setPlayer1Turn(true);
        testGame.checkForGameOver();

        //Assert
        Assert.assertTrue("Last column vertical upper right corner win condition does not end the game", testGame.isGameOver());
    }
    @Test
    public void check_last_col_vertical_win_lower_right_corner () {
        //Arrange
        int [][] board = new int[][] {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 1}
        };

        //Act
        testGame.setBoard(board);
        testGame.setPlayer1Turn(true);
        testGame.checkForGameOver();

        //Assert
        Assert.assertTrue("Last column vertical lower right corner win condition does not end the game", testGame.isGameOver());
    }
    //Positive slope diagonal win tests

    @Test
    public void check_positive_diagonal_win_lower_left_corner () {
        //Arrange
        int [][] board = new int[][] {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0}
        };

        //Act
        testGame.setBoard(board);
        testGame.setPlayer1Turn(true);
        testGame.checkForGameOver();

        //Assert
        Assert.assertTrue("Lower left corner positive diagonal win condition does not end the game", testGame.isGameOver());
    }

    @Test
    public void check_positive_diagonal_win_upper_left_corner () {
        //Arrange
        int [][] board = new int[][] {
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        //Act
        testGame.setBoard(board);
        testGame.setPlayer1Turn(true);
        testGame.checkForGameOver();

        //Assert
        Assert.assertTrue("Upper left corner positive diagonal win condition does not end the game", testGame.isGameOver());
    }
    @Test
    public void check_positive_diagonal_win_upper_right_corner () {
        //Arrange
        int [][] board = new int[][] {
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        //Act
        testGame.setBoard(board);
        testGame.setPlayer1Turn(true);
        testGame.checkForGameOver();

        //Assert
        Assert.assertTrue("Upper right corner positive diagonal win condition does not end the game", testGame.isGameOver());
    }
    @Test
    public void check_positive_diagonal_win_lower_right_corner () {
        //Arrange
        int [][] board = new int[][] {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0}
        };

        //Act
        testGame.setBoard(board);
        testGame.setPlayer1Turn(true);
        testGame.checkForGameOver();

        //Assert
        Assert.assertTrue("Lower right corner positive diagonal win condition does not end the game", testGame.isGameOver());
    }

    //Negative slope diagonal win tests
    @Test
    public void check_negative_diagonal_win_lower_left_corner () {
        //Arrange
        int [][] board = new int[][] {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0}
        };

        //Act
        testGame.setBoard(board);
        testGame.setPlayer1Turn(true);
        testGame.checkForGameOver();

        //Assert
        Assert.assertTrue("Lower left corner negative diagonal win condition does not end the game", testGame.isGameOver());
    }
    @Test
    public void check_negative_diagonal_win_upper_left_corner () {
        //Arrange
        int [][] board = new int[][] {
                {1, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        //Act
        testGame.setBoard(board);
        testGame.setPlayer1Turn(true);
        testGame.checkForGameOver();

        //Assert
        Assert.assertTrue("Upper left corner negative diagonal win condition does not end the game", testGame.isGameOver());
    }
    @Test
    public void check_negative_diagonal_win_upper_right_corner () {
        //Arrange
        int [][] board = new int[][] {
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        //Act
        testGame.setBoard(board);
        testGame.setPlayer1Turn(true);
        testGame.checkForGameOver();

        //Assert
        Assert.assertTrue("Upper right corner negative diagonal win condition does not end the game", testGame.isGameOver());
    }
    @Test
    public void check_negative_diagonal_win_lower_right_corner () {
        //Arrange
        int [][] board = new int[][] {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1}
        };

        //Act
        testGame.setBoard(board);
        testGame.setPlayer1Turn(true);
        testGame.checkForGameOver();

        //Assert
        Assert.assertTrue("Lower right corner negative diagonal win condition does not end the game", testGame.isGameOver());
    }

    //Full Board Game Over Test

    @Test
    public void check_full_board_ends_game () {
        //Arrange
        int [][] board = new int[][] {
                {3, 3, 3, 3, 3, 3, 3},
                {3, 3, 3, 3, 3, 3, 3},
                {3, 3, 3, 3, 3, 3, 3},
                {3, 3, 3, 3, 3, 3, 3},
                {3, 3, 3, 3, 3, 3, 3},
                {3, 3, 3, 3, 3, 3, 3}
        };

        //Act
        testGame.setBoard(board);
        testGame.setPlayer1Turn(true);
        testGame.checkForGameOver();

        //Assert
        Assert.assertTrue("Full Board should end the game", testGame.isGameOver());
    }
}
