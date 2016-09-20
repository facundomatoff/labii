/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author mikem
 */
/**
 * Created by mikem on 9/19/2016.
 */
import java.util.*;
import java.util.Scanner;

public class BattleShip {
    Scanner input = new Scanner(System.in);
    public static final boolean DEBUG = false;

    public static void breakln() {
        System.out.println("_____________________________________");
        System.out.println("");
    }

    public static void createBoard(String[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                board[r][c] = "~";
            }
        }
    }

    public static void showBoard(String[][] board) {
        breakln();
        for (int r = 0; r < board.length; r++) {
            if (DEBUG == true) {
                for (int c = 0; c < board[0].length; c++) {
                    System.out.print(" " + board[r][c]);
                }
                System.out.println("");
            } else {
                for (int c = 0; c < board[0].length; c++) {
                    if (board[r][c].equals("S")) {
                        System.out.print(" " + "~");
                    } else {
                        System.out.print(" " + board[r][c]);
                    }
                }
                System.out.println("");
            }
        }
        breakln();
    }

    public static void createShip(String[][] board, int size) {
        if (Math.random() < 0.5) {
            int col = (int) (Math.random() * 5);
            int row = (int) (Math.random() * 7);
            for (int i = 0; i < size; i++) {
                board[row][col + i] = "S";
            }
        } else {
            int col = (int) (Math.random() * 7);
            int row = (int) (Math.random() * 5);
            for (int i = 0; i < size; i++) {
                board[row + i][col] = "S";
            }
        }
    }

    public static int userFire(String[][] board, int hits, int torps) {
        Scanner input = new Scanner(System.in);
        int row, col;
        System.out.println("Tu Tienes: " + torps + " torpedos todavía!");
        System.out.println("Selecciona una fila para disparar(1-8): ");
        row = input.nextInt();
        while (row > 8 || row < 1) // Error que verifica por las filas
        {
            System.out.println("Ingresa una fila valida (1 -> 8)");
            row = input.nextInt();
        }
        System.out.println("Selecciona una columna para disparar (1-8): ");
        col = input.nextInt();
        while (col > 8 || col < 1) // Error que verifica por las columnas
        {
            System.out.println("Ingresa una columna valida (1 -> 8)");
            col = input.nextInt();
        }
        if (board[row - 1][col - 1].equals("S")) {
            hits++;
            System.out.println("~~~~~~~ HIT ~~~~~~~");
            board[row - 1][col - 1] = "!";
        } else {
            System.out.println("~~~~~~~ MISS ~~~~~~~");
            board[row - 1][col - 1] = "M";
        }
        return hits;
    }

    public static void finall(int hits, int torps) {
        if (hits < 4)
            System.out.println("Lo lamento, perdiste por no haber hundido ningun barco.");
        if (torps < 1)
            System.out.println("Haz perdido todos los torpedos");
        else if (hits >= 4) {
            System.out.println("Haz tenido exito hundiendo un barco, Gracias por jugar!");
        }
        System.out.println("Buen juego!");
    }

    public static void main(String[] arg) {
        String[][] board = new String[8][8];
        createBoard(board);
        createShip(board, 4);
        int torps = 15;
        int hits = 0;
        /// Starting real stuff
        while (torps > 0 && hits < 4) {
            showBoard(board);
            hits = userFire(board, hits, torps);
            torps--;
        }
        finall(hits, torps);
    }
}