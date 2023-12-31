package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private final int ROWS = 6;
    private final int COLUMNS = 7;
    //private final int BLANK = 0;
    private final int PLAYER1 = 1;
    private final int PLAYER2 = 2;
    private boolean isPlayer1Turn;
    private boolean isGameOver = false;

    private int[][] board = new int[ROWS][COLUMNS];

    public Game () {
        chooseFirstPlayer();

        while (!isGameOver) {
            displayBoard();
            playPiece();
        }

    }
    public Game (int[][] board) { // for testing only
        this.board = board;
        this.isGameOver = false;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setPlayer1Turn(boolean player1Turn) {
        isPlayer1Turn = player1Turn;
    }

    public void displayBoard() {
        System.out.println("     ***CURRENT BOARD***   ");
        System.out.println();
        System.out.println("     Choice of Columns:");
        System.out.println("  1   2   3   4   5   6   7");
        System.out.println("_____________________________");
        for (int i = 0; i < ROWS; i++) {
            System.out.println("| " + board[i][0] + " | "
                    + board[i][1] + " | "
                    + board[i][2] + " | "
                    + board[i][3] + " | "
                    + board[i][4] + " | "
                    + board[i][5] + " | "
                    + board[i][6] + " | ");
            System.out.println("-----------------------------");
        }
        System.out.println();
    }

    public void chooseFirstPlayer () {
        Random random = new Random();

        int randomInt = random.nextInt(0, 2);

        setPlayer1Turn(randomInt == 0);
    }

    public int playerColChoice () {
        Scanner input = new Scanner(System.in);

        if (isPlayer1Turn) {
            System.out.println("It is Player 1's turn");
        } else {
            System.out.println("It is Player 2's turn");
        }

        String selectedColString;
        boolean hasChoice = false;
        do {
            System.out.println("Which column would you like to play? (1 - 7)");
            selectedColString = input.nextLine();

            if (!selectedColString.equals("1") &&
                    !selectedColString.equals("2") &&
                    !selectedColString.equals("3") &&
                    !selectedColString.equals("4") &&
                    !selectedColString.equals("5") &&
                    !selectedColString.equals("6") &&
                    !selectedColString.equals("7")) {
                System.out.println("Invalid choice.  Please try again");
            } else {
                int selectedCol = Integer.parseInt(selectedColString) - 1;
                boolean isFreeSpace = false;
                for (int i = 0; i < ROWS; i++) {
                    if (board[i][selectedCol] == 0) {
                        isFreeSpace = true;
                        break;
                    }
                }
                if (isFreeSpace) {
                    hasChoice = true;
                } else {
                    System.out.println("That column is full.  Please try again.");
                }
            }
        } while (!hasChoice);

        return Integer.parseInt(selectedColString);
    }
    public void playPiece () {
        int playerChoice = playerColChoice() - 1;
        int playerPiece = PLAYER1;

        if(!isPlayer1Turn) {
            playerPiece = PLAYER2;
        }

        for (int i = 0; i < ROWS; i++) {
            if (board[i][playerChoice] != 0) {
                board[i - 1][playerChoice] = playerPiece;
                break;
            } else if (i == ROWS - 1) {
                board[ROWS - 1][playerChoice] = playerPiece;
            }
        }
        checkForGameOver();
        isPlayer1Turn = !isPlayer1Turn;
    }

    public void playPiece (int selectedCol) { // used for testing only
        int playerChoice = selectedCol - 1;
        int playerPiece = PLAYER1;

        if(!isPlayer1Turn) {
            playerPiece = PLAYER2;
        }

        for (int i = 0; i < ROWS; i++) {
            if (board[i][playerChoice] != 0) {
                board[i - 1][playerChoice] = playerPiece;
                break;
            } else if (i == ROWS - 1) {
                board[ROWS - 1][playerChoice] = playerPiece;
            }
        }
        checkForGameOver();
        isPlayer1Turn = !isPlayer1Turn;
    }

    public void checkForGameOver () {
        //Check for full board
        boolean isBoardFull = true;
        int playerPiece = PLAYER1;

        if (!isPlayer1Turn) {
            playerPiece = PLAYER2;
        }

        //Check for full board
        for (int i = 0; i < ROWS;i ++) {
            for (int n = 0; n < COLUMNS;n++) {
                if (board[i][n] == 0) {
                    isBoardFull = false;
                    break;
                }
            }
        }
        if (isBoardFull) {
            displayBoard();  //Show that the board is full
            System.out.println("Board is full.  The game ends in a tie!");
            isGameOver = true;
        }

        //Check for horizontal Victory

        for (int i = 0; i < ROWS;i ++) {
            for (int n = 0; n < COLUMNS - 3;n++) {
                if (board[i][n] == playerPiece &&
                        board[i][n + 1] == playerPiece &&
                        board[i][n + 2] == playerPiece &&
                        board[i][n + 3] == playerPiece) {
                    displayBoard(); //Show that Player won
                    System.out.println("Game Over.  Player " + playerPiece + " wins!");
                    isGameOver = true;
                    }
                }
            }

        //Check for vertical Victory
        for (int i = 0; i < ROWS - 3;i ++) {
            for (int n = 0; n < COLUMNS;n++) {
                if (board[i][n] == playerPiece &&
                        board[i + 1][n] == playerPiece &&
                        board[i + 2][n] == playerPiece &&
                        board[i + 3][n] == playerPiece) {
                    displayBoard(); //Show that Player won
                    System.out.println("Game Over.  Player " + playerPiece + " wins!");
                    isGameOver = true;
                }
            }
        }
        //Check for diagonal down victory
        for (int i = 0; i < ROWS - 3;i ++) {
            for (int n = 0; n < COLUMNS - 3;n++) {
                if (board[i][n] == playerPiece &&
                        board[i + 1][n + 1] == playerPiece &&
                        board[i + 2][n + 2] == playerPiece &&
                        board[i + 3][n + 3] == playerPiece) {
                    displayBoard(); //Show that Player won
                    System.out.println("Game Over.  Player " + playerPiece + " wins!");
                    isGameOver = true;
                }
            }
        }

        //Check for diagonal up victory
        for (int i = 3; i < ROWS;i++) {
            for (int n = 0; n < COLUMNS - 3;n++) {
                if (board[i][n] == playerPiece &&
                        board[i - 1][n + 1] == playerPiece &&
                        board[i - 2][n + 2] == playerPiece &&
                        board[i - 3][n + 3] == playerPiece) {
                    displayBoard(); //Show that Player won
                    System.out.println("Game Over.  Player " + playerPiece + " wins!");
                    isGameOver = true;
                }
            }
        }

    }
}
