package com.example.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    final char EMPTY_CELL = ' ';
    String playerName;
    char playerCharacter;
    char aiCharacter;
    static int aiLevel;

    char[][] gameField;
    Random random;
    Scanner scanner;

    public TicTacToe() {
        gameField = new char[4][4];
        random = new Random();
        scanner = new Scanner(System.in);
    }

    void game() {
        System.out.println("Enter your name: ");
        playerName = scanner.next();
        System.out.println(
                "Welcome to game " + playerName + "\n" +
                        "Choose your character: " + "\n" +
                        "1 - X" + "\n" +
                        "2 - 0");
        switch (scanner.nextInt()) {
            case (1):
                playerCharacter = 'X';
                aiCharacter = '0';
            case (2):
                playerCharacter = '0';
                aiCharacter = 'X';
        }
        System.out.println(
                "Your character is - " + playerCharacter);
        initTable();
        printGameField();
        while (true) {
            turnHuman();
            if (checkWin(playerCharacter)) {
                System.out.println("You Win!");
                break;
            }
            if (tableIsFull()) {
                System.out.println("Draw!");
                break;
            }
            turnAI();
            printGameField();
            if (checkWin(aiCharacter)) {
                System.out.println("AI Win!");
                break;
            }
            if (tableIsFull()) {
                System.out.println("Draw!");
                break;
            }
        }
        System.out.println("Game Over.");
        printGameField();
    }

    void initTable() {
        for (int row = 0; row < 4; row++)
            for (int col = 0; col < 4; col++)
                gameField[row][col] = EMPTY_CELL;
    }

    void turnHuman() {
        int x, y;
        System.out.println("Enter Column: ");
        x = scanner.nextInt() - 1;
        System.out.println("Enter Line: ");
        y = scanner.nextInt() - 1;
        if (isCellValid(x, y)) {
            gameField[y][x] = playerCharacter;
        } else {
            System.out.println("Your input is incorrect!");
            turnHuman();
        }
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= 4 || y >= 4)
            return false;
        if (gameField[y][x] == EMPTY_CELL) {
            return true;
        } else {
            System.out.println("This Cell is busy!");
            return false;
        }
    }

    boolean checkWin(char checks) {
        for (int i = 0; i < 4; i++)
            if ((gameField[i][0] == checks && gameField[i][1] == checks &&
                    gameField[i][2] == checks && gameField[i][3] == checks) ||
                    (gameField[0][i] == checks && gameField[1][i] == checks &&
                            gameField[2][i] == checks && gameField[3][i] == checks))
                return true;
        if ((gameField[0][0] == checks && gameField[1][1] == checks &&
                gameField[2][2] == checks && gameField[3][3] == checks) ||
                (gameField[3][0] == checks && gameField[2][1] == checks &&
                        gameField[1][2] == checks && gameField[0][3] == checks))
            return true;
        return false;
    }

    boolean tableIsFull() {
        for (int row = 0; row < 4; row++)
            for (int col = 0; col < 4; col++)
                if (gameField[row][col] == EMPTY_CELL)
                    return false;
        return true;
    }

    void turnAI() {
        if (aiLevel == 1) {
            turnLvl1();
        } else if (aiLevel == 2) {
            turnLvl2();
        }
    }

    private void turnLvl1() {
        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!isCellValid(x, y));
        gameField[y][x] = aiCharacter;
    }

    private void turnLvl2() {
        int x, y;
        for (int i = 0; i < 3; i++){
            if (gameField[i][0]
            ) {
            }
        }

    }

    void printGameField() {
        System.out.println(
                "         C   O   L   U   M   N" + "\n" +
                        "          1     2     3     4" + "\n" +
                        "L      .-----.-----.-----.-----." + "\n" +
                        "    1  |  " + gameField[0][0] + "  |  " + gameField[0][1] + "  |  " + gameField[0][2] + "  |  " + gameField[0][3] + "  |" + "\n" +
                        "I      '-----'-----'-----'-----'" + "\n" +
                        "    2  |  " + gameField[1][0] + "  |  " + gameField[1][1] + "  |  " + gameField[1][2] + "  |  " + gameField[1][3] + "  |" + "\n" +
                        "N      '-----'-----'-----'-----'" + "\n" +
                        "    3  |  " + gameField[2][0] + "  |  " + gameField[2][1] + "  |  " + gameField[2][2] + "  |  " + gameField[2][3] + "  |" + "\n" +
                        "E      '-----'-----'-----'-----'" + "\n" +
                        "    4  |  " + gameField[3][0] + "  |  " + gameField[3][1] + "  |  " + gameField[3][2] + "  |  " + gameField[3][3] + "  |");
    }
}
