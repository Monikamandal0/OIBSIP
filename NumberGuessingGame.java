import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private static final int MIN = 1;
    private static final int MAX = 100;
    private static final int MAX_ATTEMPTS = 10;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        int round = 1;
        String choice;

        System.out.println("======================================");
        System.out.println("        NUMBER GUESSING GAME");
        System.out.println("======================================");

        do {
            int secretNumber = random.nextInt(MAX - MIN + 1) + MIN;
            int attempts = 0;
            boolean correct = false;

            System.out.println("\nRound " + round);
            System.out.println("--------------------------------------");
            System.out.println("Guess a number between " + MIN + " and " + MAX);
            System.out.println("You have " + MAX_ATTEMPTS + " attempts.");

            while (attempts < MAX_ATTEMPTS) {

                System.out.print("\nEnter your guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    scanner.next();
                    continue;
                }

                int guess = scanner.nextInt();

                if (guess < MIN || guess > MAX) {
                    System.out.println(
                            "Your guess must be between " + MIN + " and " + MAX + ".");
                    continue;
                }

                attempts++;

                if (guess == secretNumber) {
                    correct = true;
                    score++;

                    System.out.println("\nCorrect! Nice guess.");
                    System.out.println("Attempts used: " + attempts);
                    break;
                }

                if (guess < secretNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                System.out.println(
                        "Attempts left: " + (MAX_ATTEMPTS - attempts));
            }

            if (!correct) {
                System.out.println("\nYou ran out of attempts.");
                System.out.println("The number was: " + secretNumber);
            }

            System.out.println("\nCurrent score: " + score);

            System.out.print("\nPlay another round? (Y/N): ");
            choice = scanner.next();

            round++;

        } while (choice.equalsIgnoreCase("Y"));

        System.out.println("\n======================================");
        System.out.println("             GAME OVER");
        System.out.println("======================================");
        System.out.println("Rounds played : " + (round - 1));
        System.out.println("Final score   : " + score);
        System.out.println("Thanks for playing!");

        scanner.close();
    }
}
