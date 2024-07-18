import java.util.Scanner;

// Creating our main method. We call methods from the MineSweeper class we created.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int numRows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int numCols = scanner.nextInt();

        MineSweeper game = new MineSweeper(numRows, numCols);
        game.initializeGame();
        game.playGame();

        scanner.close();
    }
}
