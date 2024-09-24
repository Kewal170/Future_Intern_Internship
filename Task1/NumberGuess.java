import java.util.Scanner;

class NumberGuess {

    // Generates a random integer between 1 and 10
    public static int randomNum() {
        return (int) (Math.random() * 10) + 1;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;

        // Introduction to the game
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number between 1 and 10. You have 3 tries!");

        while (playAgain) {
            int num = randomNum();
            int attempts = 3;
            boolean won = false;

            while (attempts > 0) {
                System.out.print("\nEnter your guess: ");
                
                // Validate input
                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number between 1 and 10.");
                    sc.next(); // Clear invalid input
                    continue;
                }
                
                int guess = sc.nextInt();

                // Check if the guess is within the valid range
                if (guess < 1 || guess > 10) {
                    System.out.println("Please enter a number between 1 and 10.");
                    continue;
                }

                if (guess == num) {
                    System.out.println("\n🎉 Congratulations! You guessed it right in " + (4 - attempts) + " attempts!");
                    System.out.println("You are a true guess master! ");
                    won = true;
                    break;
                } else if (guess > num) {
                    System.out.println("A little lower... Try again!");
                } else {
                    System.out.println("A little higher... Keep going!");
                }

                attempts--;

                if (attempts > 0) {
                    System.out.println("You have " + attempts + " tries remaining.");
                }

                // Provide hints if the player has made a guess
                if (attempts == 2) {
                    System.out.println("Hint: Try a number between " + Math.max(1, guess - 2) + " and " + Math.min(10, guess + 2));
                }
            }

            // If the player didn't win, reveal the number
            if (!won) {
                System.out.println("\nYou Lost! The correct number was " + num + ". Better luck next time!");
            }

            // Ask if the player wants to play again
            System.out.print("\nWould you like to play again? (yes/no): ");
            String response = sc.next().toLowerCase();

            if (!response.equals("yes")) {
                playAgain = false;
                System.out.println("\nThanks for playing! Come back soon!");
            }
        }

        sc.close();
    }
}
