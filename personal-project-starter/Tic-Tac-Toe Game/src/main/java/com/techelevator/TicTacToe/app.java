package com.techelevator.TicTacToe;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class app {

    static String[] slot;
    static String turn;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        slot = new String[9];
        turn = "X";
        String winner = null;

        for (int i = 0; i < 9; i++) {
            slot[i] = String.valueOf(i + 1);
        }

        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        printToBoard();

        System.out.println(
                "X will play first. Enter a slot number to place X in:");

        while (winner == null) {
            int numInput;

            // Exception handling.
            // numInput will take input from user like from 1 to 9.
            // If it is not in range from 1 to 9.
            // then it will show you an error "Invalid input."
            try {
                numInput = in.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println(
                            "Invalid input; re-enter slot number:");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println(
                        "Invalid input; re-enter slot number:");
                continue;
            }

            // This game has two player x and O.
            // Here is the logic to decide the turn.
            if (slot[numInput - 1].equals(
                    String.valueOf(numInput))) {
                slot[numInput - 1] = turn;

                if (turn.equals("X")) {
                    turn = "O";
                } else {
                    turn = "X";
                }

                printToBoard();
                winner = winner();
            } else {
                System.out.println(
                        "Slot already taken; re-enter slot number:");
            }
        }

        // If no one win or lose from both player x and O.
        // then here is the logic to print "draw".
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println(
                    "It's a draw! ");
        }

        // For winner -to display Congratulations! message.
        else {
            System.out.println(
                    "Congratulations! " + winner
                            + "'s have won! ");
        }
    }

    static String winner() {
        for (int i = 0; i < 8; i++) {
            String line = null;

            switch (i) {
                case 0:
                    line = slot[0] + slot[1] + slot[2];
                    break;
                case 1:
                    line = slot[3] + slot[4] + slot[5];
                    break;
                case 2:
                    line = slot[6] + slot[7] + slot[8];
                    break;
                case 3:
                    line = slot[0] + slot[3] + slot[6];
                    break;
                case 4:
                    line = slot[1] + slot[4] + slot[7];
                    break;
                case 5:
                    line = slot[2] + slot[5] + slot[8];
                    break;
                case 6:
                    line = slot[0] + slot[4] + slot[8];
                    break;
                case 7:
                    line = slot[2] + slot[4] + slot[6];
                    break;
            }
            //For X winner
            if (line.equals("XXX")) {
                return "X";
            }

            // For O winner
            else if (line.equals("OOO")) {
                return "O";
            }
        }

        for (int i = 0; i < 9; i++) {
            if (Arrays.asList(slot).contains(
                    String.valueOf(i + 1))) {
                break;
            } else if (i == 8) {
                return "draw";
            }
        }

        // To enter the X Or O at the exact place on board.
        System.out.println(
                turn + "'s turn; enter a slot number to place "
                        + turn + " in:");
        return null;
    }


    static void printToBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + slot[0] + " | "
                + slot[1] + " | " + slot[2]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + slot[3] + " | "
                + slot[4] + " | " + slot[5]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + slot[6] + " | "
                + slot[7] + " | " + slot[8]
                + " |");
        System.out.println("|---|---|---|");
    }

}

