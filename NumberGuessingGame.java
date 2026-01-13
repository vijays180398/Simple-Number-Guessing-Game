import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int maxAttempts = 5;
        int randomNumber = random.nextInt(100) + 1; // 1 to 100
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("🎯 Welcome to Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100");
        System.out.println("You have " + maxAttempts + " attempts.\n");

        while (attempts < maxAttempts) {

            System.out.print("Enter your guess: ");

            if (!sc.hasNextInt()) {
                System.out.println("❌ Invalid input. Please enter a number.");
                sc.next(); // clear invalid input
                continue;
            }

            int guess = sc.nextInt();
            attempts++;

            if (guess < randomNumber) {
                System.out.println("Too Low!");
            } else if (guess > randomNumber) {
                System.out.println("Too High!");
            } else {
                System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempts.");
                hasGuessedCorrectly = true;
                break;
            }

            System.out.println("Attempts left: " + (maxAttempts - attempts) + "\n");
        }

        if (!hasGuessedCorrectly) {
            System.out.println("😞 Game Over! The correct number was: " + randomNumber);
        }

        sc.close();
    }
}
