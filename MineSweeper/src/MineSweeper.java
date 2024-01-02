import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    private char[][] board;
    private char[][] solution;
    private int numRows;
    private int numCols;
    private int mineCount;

    // MineSweeper sınıfının kurucu metodunu oluşturuyoruz.
    public MineSweeper(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.mineCount = numRows * numCols / 4;  // Diziye ait eleman sayısının çeyreği kadar mayın yerleştiriyoruz.
        this.board = new char[numRows][numCols];
        this.solution = new char[numRows][numCols];
    }

    // Oyun tahtasını başlatan metodumuzu oluşturuyoruz.
    public void initializeGame() {
        // Oyun tahtalarını başlatan döngüyü oluşturuyoruz.
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                board[i][j] = '-';
                solution[i][j] = '0';
            }
        }

        // Mayınları yerleştiriyoruz.
        placeMines();
    }

    // Mayınları yerleştiren metodumuzu oluşturuyoruz.
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

    // Tahtayı ekrana yazdıran metodumuzu oluşturuyoruz.
    public void displayBoard(char[][] board) {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Oyunu oynatan metodumuzu oluşturuyoruz. Kullanıcıdan değer alıyoruz.
    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;

        while (!gameOver) {
            System.out.println("Oyun Tahtası:");
            displayBoard(board);

            System.out.print("Satır girin: ");
            int row = scanner.nextInt();
            System.out.print("Sütun girin: ");
            int col = scanner.nextInt();

            if (row < 0 || row >= numRows || col < 0 || col >= numCols) {
                System.out.println("Geçersiz hamle. Lütfen tekrar deneyin.");
                continue;
            }

            if (solution[row][col] == 'M') {
                System.out.println("Mayına bastınız! Oyun sona erdi.");
                gameOver = true;
            } else {
                uncoverCell(row, col);
                if (isGameWon()) {
                    System.out.println("Tebrikler! Oyunu kazandınız!");
                    gameOver = true;
                }
            }
        }
        scanner.close();
    }

    // Belirli bir hücreyi açan metodumuzu oluştuyoruz.
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

    // Belirli bir hücre etrafındaki mayınları sayan metodu oluşturduk.
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


    // Oyunun kazanılıp kazanılmadığını kontrol eden metodu da tanımlıyoruz.

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