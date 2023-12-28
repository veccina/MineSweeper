import java.util.Scanner;

// Ana metodumuzu oluşturuyoruz. Oluşturduğumuz MineSweeper sınıfından metotları çağırıyoruz.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Oyun tahtasının boyutunu girin: ");
        int size = scanner.nextInt();

        MineSweeper game = new MineSweeper(size);
        game.initializeGame();
        game.playGame();

        scanner.close();
    }
}