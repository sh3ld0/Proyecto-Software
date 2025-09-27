package com.example.tictactoe;

import java.util.Scanner;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Scanner scanner;

    public Game() {
        board = new Board();
        scanner = new Scanner(System.in);
        initializePlayers();
        currentPlayer = player1;
    }

    private void initializePlayers() {
        System.out.println("Ingrese nombre del Jugador 1 (X): ");
        String name1 = scanner.nextLine();
        player1 = new Player(name1, 'X');

        System.out.println("Ingrese nombre del Jugador 2 (O): ");
        String name2 = scanner.nextLine();
        player2 = new Player(name2, 'O');
    }

    public void start() {
        System.out.println("¡Bienvenidos al Tres en Raya!");
        board.printBoard();

        while (true) {
            System.out.println(currentPlayer.getName() + " (" + currentPlayer.getMark() + "), es tu turno.");
            System.out.print("Ingresa fila (0-2): ");
            int row = scanner.nextInt();
            System.out.print("Ingresa columna (0-2): ");
            int col = scanner.nextInt();

            if (board.placeMark(row, col, currentPlayer.getMark())) {
                board.printBoard();
                if (board.checkWin(currentPlayer.getMark())) {
                    System.out.println("¡" + currentPlayer.getName() + " gana!");
                    break;
                } else if (board.isBoardFull()) {
                    System.out.println("¡Empate!");
                    break;
                }
                switchPlayer();
            } else {
                System.out.println("Movimiento inválido. Intenta de nuevo.");
            }
        }
        scanner.close();
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}