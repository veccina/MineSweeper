import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    private char[][] board;
    private char[][] solution;
    private int numRows;
    private int numCols;
    private int mineCount;

    // Constructor method for the MineSweeper class.
    public MineSweeper(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.mineCount = numRows * numCols / 4;  // Place mines equal to a quarter of the total number of elements in the array.
        this.board = new char[numRows][numCols];
        this.solution = new char[numRows][numCols];
    }

    // Method to initialize the game board.
    public void initializeGame() {
        // Loop to initialize the game boards.
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                board[i][j] = '-';
                solution[i][j] = '0';
            }
        }

        // Place the mines.
        placeMines();
    }

    // Method to place the mines.
    public void placeMines() {
        Random random = new Random();

        for (int i = 0; i < mineCount; i++) {
            int row, col;
            do {
                row = random.nextInt(numRows);
                col = random.nextInt(numCols);
            } while (solution[row][col] == 'M');

            solution[row][col] = 'M';
        }
    }

    // Method to print the board to the screen.
    public void displayBoard(char[][] board) {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to play the game. We get input from the user.
    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;

        while (!gameOver) {
            System.out.println("Game Board:");
            displayBoard(board);

            System.out.print("Enter row: ");
            int row = scanner.nextInt();
            System.out.print("Enter column: ");
            int col = scanner.nextInt();

            if (row < 0 || row >= numRows || col < 0 || col >= numCols) {
                System.out.println("Invalid move. Please try again.");
                continue;
            }

            if (solution[row][col] == 'M') {
                System.out.println("You hit a mine! Game over.");
                gameOver = true;
            } else {
                uncoverCell(row, col);
                if (isGameWon()) {
                    System.out.println("Congratulations! You won the game!");
                    gameOver = true;
                }
            }
        }
        scanner.close();
    }

    // Method to uncover a specific cell.
    public void uncoverCell(int row, int col) {
        if (board[row][col] != '-') return;

        int minesAround = countMinesAround(row, col);
        board[row][col] = (char) (minesAround + '0');

        if (minesAround == 0) {
            int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

            for (int i = 0; i < 8; i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols) {
                    uncoverCell(newRow, newCol);
                }
            }
        }
    }

    // Method to count mines around a specific cell.
    public int countMinesAround(int row, int col) {
        int minesAround = 0;
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols && solution[newRow][newCol] == 'M') {
                minesAround++;
            }
        }

        return minesAround;
    }

    // Method to check if the game is won.
    public boolean isGameWon() {
        int uncoveredCount = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (board[i][j] != '-') {
                    uncoveredCount++;
                }
            }
        }
        return uncoveredCount == (numRows * numCols - mineCount);
    }
}
