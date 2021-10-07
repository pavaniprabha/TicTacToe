package com.blz;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	static int x = 1;
    static Scanner SC = new Scanner(System.in);
    static char[] board = new char[10];

    public static void main(String[] args) {
        uc1();
        uC2Input();
    }

    public static void uc1() {
        for (int i = 1; i <= 9; i++) {
            board[i] = ' ';
        }
    }

    public static void uC2Input() {
        System.out.println("Choose your Character");
        System.out.println(" \n1. O \n2. X ");
        char isPlayerOne = SC.next().charAt(0);
        System.out.println("Player Character is " + isPlayerOne);
        if (isPlayerOne == 'x' || isPlayerOne == 'X') {
            System.out.println("Computer Character is O");
        } else if (isPlayerOne == 'o' || isPlayerOne == 'O') {
            System.out.println("Computer Character is X");
        }
        uC4UserAbilityToMove(isPlayerOne);
        computerPlay(isPlayerOne);
        Nineplays(isPlayerOne);
    }

    //print board
    public static void uC3Board() {
        System.out.println();
        for (int j = 1; j <= 3; j++) {
            System.out.print(board[j] + " | ");
        }
        System.out.println();
        for (int j = 4; j <= 6; j++) {
            System.out.print(board[j] + " | ");
        }
        System.out.println();
        for (int j = 7; j <= 9; j++) {
            System.out.print(board[j] + " | ");
        }
        System.out.println();
    }

    public static void uC4UserAbilityToMove(char isPlayerOne) {
        System.out.println("Play Your Move");
        int yourMove = SC.nextInt();
        if (board[yourMove] == ' ') {
            board[yourMove] = isPlayerOne;
        } else {
            System.out.println("cannot reWrite. enter again.");
            uC4UserAbilityToMove(isPlayerOne);
        }
        uC3Board();
        x = 0;
    }

    public static void computerPlay(char isPlayerOne) {
        Random computerPlay = new Random();
        int random = (computerPlay.nextInt(9)) + 1;
        if (board[random] == ' ') {
            if (isPlayerOne == 'x' || isPlayerOne == 'X') {
                board[random] = 'O';
            } else if (isPlayerOne == 'O' || isPlayerOne == 'o') {
                board[random] = 'X';
            }
        } else {
            computerPlay(isPlayerOne);
        }
        uC3Board();
        x = 1;
    }

    public static void Nineplays(char isPlayerOne) {
        for (int i = 0; i < 9; i++) {
            if (x == 1) {
                uC4UserAbilityToMove(isPlayerOne);
                if (Winner())
                {
                System.out.println("User Win...!!!");
                System.exit(0);
                }
            }
            else if ( x == 0) 
            {
                computerPlay(isPlayerOne);
                if (Winner()) {
                System.out.println("Computer Win...!!!");
                System.exit(0);
                }
            }
        }
    }

    public static boolean Winner() {
        if (((board[1] == 'X' || board[1] == 'x') && (board[2] == 'X' || board[2] == 'x') && (board[3] == 'X' || board[3] == 'x')) ||
                ((board[4] == 'X' || board[4] == 'x') && (board[5] == 'X' || board[5] == 'x') && (board[6] == 'X' || board[6] == 'x')) ||
                ((board[7] == 'X' || board[7] == 'x') && (board[8] == 'X' || board[8] == 'x') && (board[9] == 'X' || board[9] == 'x')) ||
                ((board[1] == 'X' || board[1] == 'x') && (board[5] == 'X' || board[5] == 'x') && (board[9] == 'X' || board[9] == 'x')) ||
                ((board[3] == 'X' || board[3] == 'x') && (board[5] == 'X' || board[5] == 'x') && (board[7] == 'X' || board[7] == 'x')) ||
                ((board[1] == 'X' || board[1] == 'x') && (board[4] == 'X' || board[4] == 'x') && (board[7] == 'X' || board[7] == 'x')) ||
                ((board[2] == 'X' || board[2] == 'x') && (board[5] == 'X' || board[5] == 'x') && (board[8] == 'X' || board[8] == 'x')) ||
                ((board[3] == 'X' || board[3] == 'x') && (board[6] == 'X' || board[6] == 'x') && (board[9] == 'X' || board[9] == 'x'))) {
            System.out.println();
            return true;
        }
        else if (((board[1] == 'O' || board[1] == 'o') && (board[2] == 'O' || board[2] == 'o') && (board[3] == 'O' || board[3] == 'o')) ||
                ((board[4] == 'O' || board[4] == 'o') && (board[5] == 'O' || board[5] == 'o') && (board[6] == 'O' || board[6] == 'o')) ||
                ((board[7] == 'O' || board[7] == 'o') && (board[8] == 'O' || board[8] == 'o') && (board[9] == 'O' || board[9] == 'o')) ||
                ((board[1] == 'O' || board[1] == 'o') && (board[5] == 'O' || board[5] == 'o') && (board[9] == 'O' || board[9] == 'o')) ||
                ((board[3] == 'O' || board[3] == 'o') && (board[5] == 'O' || board[5] == 'o') && (board[7] == 'O' || board[7] == 'o')) ||
                ((board[1] == 'O' || board[1] == 'o') && (board[4] == 'O' || board[4] == 'o') && (board[7] == 'O' || board[7] == 'o')) ||
                ((board[2] == 'O' || board[2] == 'o') && (board[5] == 'O' || board[5] == 'o') && (board[8] == 'O' || board[8] == 'o')) ||
                ((board[3] == 'O' || board[3] == 'o') && (board[6] == 'O' || board[6] == 'o') && (board[9] == 'O' || board[9] == 'o'))) {
            System.out.println();
            return true;
        }
        return false;
    }
}
