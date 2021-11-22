package com.example.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    final char CROSS = 'x';
    final char ZERO = '0';
    final char EMPTY_CELL = '-';

    char[][] gameField;
    Random random;
    Scanner scanner;

    public TicTacToe() {
        gameField = new char[3][3];
        random = new Random();
        scanner = new Scanner(System.in);
    }

    void game() {
        initTable();
        while (true) {
            turnHuman();
            if (checkWin(CROSS)) {
                System.out.println("You Win!");
                break;
            }
            if (tableIsFull()) {
                System.out.println("Draw!");
                break;
            }
            turnAI();
            printable();
            if (checkWin(ZERO)) {
                System.out.println("AI Win!");
                break;
            }
            if (tableIsFull()) {
                System.out.println("Draw!");
                break;
            }
        }
        System.out.println("Game Over.");
        printable();
    }

    void initTable() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                gameField[row][col] = EMPTY_CELL;
    }

    void turnHuman() {
        int x, y;
        do {
            System.out.println("Enter X and Y: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        gameField[y][x] = CROSS;
    }

    boolean checkWin(char checkingSymbol) {
        for (int i = 0; i < 3; i++)
            if ((gameField[i][0] == checkingSymbol && gameField[i][1] == checkingSymbol &&
                    gameField[i][2] == checkingSymbol) ||
                    (gameField[0][i] == checkingSymbol && gameField[1][i] == checkingSymbol &&
                            gameField[2][i] == checkingSymbol))
                return true;
        if ((gameField[0][0] == checkingSymbol && gameField[1][1] == checkingSymbol &&
                gameField[2][2] == checkingSymbol) ||
                (gameField[2][0] == checkingSymbol && gameField[1][1] == checkingSymbol &&
                        gameField[0][2] == checkingSymbol))
            return true;
        return false;
    }

    boolean tableIsFull() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (gameField[row][col] == EMPTY_CELL)
                    return false;
        return true;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= 3 || y >= 3)
            return false;
        return gameField[y][x] == EMPTY_CELL;
    }

    void printTable() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++)
                System.out.print(gameField[row][col] + " ");
            System.out.println();
        }
    }
}
