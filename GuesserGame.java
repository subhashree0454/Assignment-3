import java.util.Random;
import java.util.Scanner;

public class GuesserGame {
    private int targetNumber;
    private int maxAttempts;
    private int currentAttempt;
    private int score;

    public GuesserGame(int maxNumber, int maxAttempts) {
        Random random = new Random();
        this.targetNumber = random.nextInt(maxNumber) + 1; // Generate a random number between 1 and maxNumber
        this.maxAttempts = maxAttempts;
        this.currentAttempt = 0;
        this.score = 0;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Guesser Game!");

        while (currentAttempt < maxAttempts) {
            System.out.printf("Attempt %d/%d: Enter your guess: ", currentAttempt + 1, maxAttempts);
            int guess = scanner.nextInt();
            currentAttempt++;

            if (guess == targetNumber) {
                System.out.println("Congratulations! You guessed the correct number.");
                updateScore();
                break;
            } else if (guess < targetNumber) {
                System.out.println("Too low. Try again.");
            } else {
                System.out.println("Too high. Try again.");
            }

            if (currentAttempt == maxAttempts) {
                System.out.println("Sorry, you ran out of attempts. The correct number was: " + targetNumber);
            }
        }

        System.out.println("Your final score is: " + score);
        scanner.close();
    }

    private void updateScore() {
        // Example: Score based on remaining attempts
        score += (maxAttempts - currentAttempt + 1) * 100;
    }

    public static void main(String[] args) {
        // Example usage: Creating a game with max number 100 and max attempts 5
        GuesserGame game = new GuesserGame(100, 5);
        game.playGame();
    }
}
OUTPUT:
Welcome to the Guesser Game!
Attempt 1/5: Enter your guess: 50
Too low. Try again.
Attempt 2/5: Enter your guess: 80
Too high. Try again.
Attempt 3/5: Enter your guess: 60
Too low. Try again.
Attempt 4/5: Enter your guess: 70
Too low. Try again.
Attempt 5/5: Enter your guess: 75
Too high. Try again.
Sorry, you ran out of attempts. The correct number was: 72
Your final score is: 0
