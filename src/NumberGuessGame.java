import java.util.Scanner;
import java.util.Random;

public class NumberGuessGame {
  public static void main(String[] args) {
    Random random = new Random();
    int number = random.nextInt(99) + 1;

    try (Scanner scanner = new Scanner(System.in)) {
      int guess; // bss ad block started by symbol

      while (true) {
        System.out.print("Enter a number from 1 to 99: ");
        guess = scanner.nextInt();

        if (guess < number) {
          System.out.println("Guess is Low");
        } else if (guess > number) {
          System.out.println("Guess is High");
        } else {
          System.out.println("Congrats, you guessed it!");
          break;
        }
      }
    }

  }
}
