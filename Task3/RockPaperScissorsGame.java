import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorsGame {

    // Main method to start the game
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] choices = {"rock", "paper", "scissors"};
        
        System.out.println("Welcome to Rock, Paper, Scissors Game!");
        System.out.println("--------------------------------------");

        boolean playAgain = true;

        while (playAgain) {
            // Display choices for the user
            System.out.println("\nPlease choose one of the following:");
            System.out.println("1. Rock");
            System.out.println("2. Paper");
            System.out.println("3. Scissors");

            // Get user's input and validate it
            String userChoice = getUserChoice(scanner, choices);
            String computerChoice = choices[random.nextInt(3)];

            // Show computer's choice
            System.out.println("Computer chose: " + capitalize(computerChoice));

            // Determine the winner
            determineWinner(userChoice, computerChoice);

            // Ask if the user wants to play again
            playAgain = askToPlayAgain(scanner);
        }

        System.out.println("Thank you for playing! Goodbye!");
        scanner.close();
    }

    // Method to get user's choice with input validation
    private static String getUserChoice(Scanner scanner, String[] choices) {
        int choice = -1;

        // Loop until the user provides a valid input
        while (choice < 1 || choice > 3) {
            System.out.print("Enter your choice (1, 2, or 3): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();  
            } else {
                System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                scanner.next();  
            }
        }

        return choices[choice - 1]; // Return corresponding choice
    }

    // Method to determine and display the winner
    private static void determineWinner(String userChoice, String computerChoice) {
        System.out.println();

        // Determine the outcome based on the rules
        if (userChoice.equals(computerChoice)) {
            System.out.println("It's a tie!");
        } else if (userChoice.equals("rock") && computerChoice.equals("scissors")
                || userChoice.equals("paper") && computerChoice.equals("rock")
                || userChoice.equals("scissors") && computerChoice.equals("paper")) {
            System.out.println("Congratulations! You win!");
        } else {
            System.out.println("Computer wins! Better luck next time.");
        }
    }

    // Method to ask if the user wants to play again
    private static boolean askToPlayAgain(Scanner scanner) {
        String response;
        while (true) {
            System.out.print("\nDo you want to play again? (y/n): ");
            response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("y")) {
                return true;
            } else if (response.equals("n")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
            }
        }
    }

    // Helper method to capitalize the first letter of a string
    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
