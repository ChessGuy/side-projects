package org.example;

import java.util.Arrays;

public class Game {

    private final int ROWS = 6;
    private final int COLUMNS = 7;
    private final int BLANK = 0;
    private final int PLAYER1 = 1;
    private final int PLAYER2 = 2;

    private int[][] board = new int[ROWS][COLUMNS];


    public void displayBoard() {
        System.out.println("CURRENT BOARD       ");
        System.out.println();
        System.out.println("Choice of Columns:  ");
        System.out.println(" 1  2  3  4  5  6  7");
        System.out.println("____________________");
        for (int i = 0; i < ROWS; i++) {
            System.out.println((Arrays.toString(board[i])));
        }
    }
}
