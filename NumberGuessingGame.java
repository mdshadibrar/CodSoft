import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

      public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            int score = 0;
            int maxAttempts = 5;
            int rounds = 1;
            boolean playAgain = true;

            while (playAgain) {
                  System.out.println("\n--- Round " + rounds + " ---");
                  int targetNumber = random.nextInt(100) + 1; // Generate random number between 1 and 100
                  int attempts = 0;
                  boolean guessedCorrectly = false;

                  while (attempts < maxAttempts && !guessedCorrectly) {
                        System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Enter your guess (1-100): ");
                        int guess;

                        try {
                              guess = Integer.parseInt(scanner.nextLine());  // Read user input
                        } catch (NumberFormatException e) {
                              System.out.println("Please enter a valid number.");
                              continue;
                        }

                        attempts++;

                        if (guess < targetNumber) {
                              System.out.println("Too low!");
                        } else if (guess > targetNumber) {
                              System.out.println("Too high!");
                        } else {
                              System.out.println("Correct! You've guessed the number in " + attempts + " attempts.");
                              score += (maxAttempts - attempts + 1); // More points for fewer attempts
                              guessedCorrectly = true;
                        }
                  }

                  if (!guessedCorrectly) {
                        System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was " + targetNumber + ".");
                  }

                  // Ask if the player wants to play another round
                  System.out.print("Do you want to play another round? (yes/no): ");
                  String response = scanner.nextLine().toLowerCase();

                  if (!response.equals("yes")) {
                        playAgain = false;
                  }
                  rounds++;
            }

            System.out.println("\n--- Game Over ---");
            System.out.println("Final Score: " + score);
            System.out.println("Rounds Played: " + rounds);
            scanner.close();
      }
}
