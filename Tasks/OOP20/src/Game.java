import java.util.*;

public class Game {
    private char[][] board;
    private Player2 player1;
    private Player2 player2;
    private Player2 currentPlayer;

    public Game(Player2 player1, Player2 player2) {
        this.board = new char[3][3];
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }

    public void start() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        while (true) {
            printBoard();
            int row, col;
            do {
                System.out.println(currentPlayer.getName() + ", твой ход. Введи строку и столбец, нажимая Enter после ввода: ");
                row = readInt() - 1;
                col = readInt() - 1;
            } while (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ');

            board[row][col] = currentPlayer.getSymbol();

            if (checkWin(currentPlayer.getSymbol())) {
                printBoard();
                System.out.println(currentPlayer.getName() + " победил!");
                break;
            }

            if (checkDraw()) {
                printBoard();
                System.out.println("Ничья!");
                break;
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }

    private void printBoard() {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean checkWin(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                return true;
            }
        }

        if ((board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) || (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
            return true;
        }

        return false;
    }

    private boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private int readInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}

class Player2 {
    private String name;
    private char symbol;

    public Player2(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }
}

class Main17 {
    public static void main(String[] args) {
        Player2 player1 = new Player2("Игрок 1", 'X');
        Player2 player2 = new Player2("Игрок 2", 'O');

        Game game = new Game(player1, player2);
        game.start();
    }
}