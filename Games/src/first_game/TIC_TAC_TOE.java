
package first_game;

import java.util.Scanner;

public class TIC_TAC_TOE {

    // Colours
	static final String PURPLE = "\u001B[35m";
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String CYAN = "\u001B[36m";
    static final String BOLD = "\u001B[1m";

    static char[][] board = new char[3][3];
    static char player = 'X';

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Initialize board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }

        System.out.println(CYAN + BOLD);
        System.out.println("================================");
        System.out.println("       TIC TAC TOE GAME");
        System.out.println("================================");
        System.out.println(RESET);

        System.out.println(BLUE + "Player X" + RESET +
                " VS " + GREEN + "Player O" + RESET);

        while (true) {

            printBoard();

            System.out.println(BOLD + "Player " + player +
                    " - Your Turn!" + RESET);

            System.out.print(YELLOW + "Choose Row (0-2): " + RESET);

            if (!scanner.hasNextInt()) {
                System.out.println(RED + "Enter numbers only!" + RESET);
                scanner.next();
                continue;
            }

            int row = scanner.nextInt();

            System.out.print(YELLOW + "Choose Column (0-2): " + RESET);

            if (!scanner.hasNextInt()) {
                System.out.println(RED + "Enter numbers only!" + RESET);
                scanner.next();
                continue;
            }

            int col = scanner.nextInt();

            // Validate move
            if (row < 0 || row > 2 ||
                col < 0 || col > 2 ||
                board[row][col] != ' ') {

                System.out.println(RED +
                        "Invalid Move! Please Try Again." + RESET);
                continue;
            }

            board[row][col] = player;

            // Check winner
            if (checkWinner()) {

                printBoard();

                System.out.println(CYAN + BOLD);
                System.out.println("================================");
                System.out.println("       CONGRATULATIONS!");
                System.out.println("================================");

                System.out.println(GREEN + BOLD);
                System.out.println("       PLAYER " + player + " WON!");

                System.out.println(RESET);

                break;
            }

            // Check draw
            if (isBoardFull()) {

                printBoard();

                System.out.println(CYAN + BOLD);
                System.out.println("================================");
                System.out.println("          GAME DRAW!");
                System.out.println("================================");
                System.out.println(RESET);

                break;
            }

            // Switch player
            player = (player == 'X') ? 'O' : 'X';
        }

        scanner.close();
    }

    // Check board full
    private static boolean isBoardFull() {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }

    // Check winner
    private static boolean checkWinner() {

        // Check rows
        for (int i = 0; i < 3; i++) {

            if (board[i][0] == player &&
                board[i][1] == player &&
                board[i][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {

            if (board[0][i] == player &&
                board[1][i] == player &&
                board[2][i] == player) {
                return true;
            }
        }

        // First diagonal
        if (board[0][0] == player &&
            board[1][1] == player &&
            board[2][2] == player) {
            return true;
        }

        // Second diagonal
        if (board[0][2] == player &&
            board[1][1] == player &&
            board[2][0] == player) {
            return true;
        }

        return false;
    }

    // Print board
    private static void printBoard() {

        System.out.println();
        System.out.println(CYAN + BOLD +
                "       TIC TAC TOE" + RESET);

        System.out.println(PURPLE + "      0     1     2" + RESET);

        System.out.println("   +-----+-----+-----+");

        for (int i = 0; i < 3; i++) {

            System.out.print(YELLOW + " " + i + RESET + " ");

            for (int j = 0; j < 3; j++) {

                char value = board[i][j];

                String color = RESET;

                if (value == 'X') {
                    color = BLUE + BOLD;
                } else if (value == 'O') {
                    color = GREEN + BOLD;
                }

                System.out.print("|  " + color +
                        value + RESET + "  ");
            }

            System.out.println("|");
            System.out.println("   +-----+-----+-----+");
        }

        System.out.println();
    }
}
