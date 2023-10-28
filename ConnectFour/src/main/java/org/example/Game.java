package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private final int ROWS = 6;
    private final int COLUMNS = 7;
    private final int BLANK = 0;
    private final int PLAYER1 = 1;
    private final int PLAYER2 = 2;
    private boolean isPlayer1Turn;

    private int[][] board = new int[ROWS][COLUMNS];

    public void setPlayer1Turn(boolean player1Turn) {
        isPlayer1Turn = player1Turn;
    }

    public void displayBoard() {
        System.out.println("CURRENT BOARD       ");
        System.out.println();
        System.out.println("Choice of Columns:  ");
        System.out.println(" 1  2  3  4  5  6  7");
        System.out.println("____________________");
        for (int i = 0; i < ROWS; i++) {
            System.out.println((Arrays.toString(board[i])));
        }
        System.out.println();
    }

    public void chooseFirstPlayer () {
        Random random = new Random();

        int randomInt = random.nextInt(0, 2);

        if (randomInt == 0) {
            setPlayer1Turn(true);
        } else {
            setPlayer1Turn(false);
        }
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
                int selectedCol = Integer.parseInt(selectedColString);
                boolean isFreeSpace = false;
                for (int i = 0; i < ROWS; i++) {
                    if (board[i][selectedCol] == 0) {
                        isFreeSpace = true;
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
        return;
    }
}
