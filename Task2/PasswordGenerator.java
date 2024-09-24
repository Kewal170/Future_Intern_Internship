import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator {

    // Method to generate the password based on user's input
    public static String generatePassword(int length, boolean useUppercase, boolean useLowercase, boolean useNumbers, boolean useSpecial) {
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialCharacters = "!@#$%^&*()-_=+<>?";

        String characterPool = "";

        // Add selected character types to the pool
        if (useUppercase) {
            characterPool += uppercaseLetters;
        }
        if (useLowercase) {
            characterPool += lowercaseLetters;
        }
        if (useNumbers) {
            characterPool += numbers;
        }
        if (useSpecial) {
            characterPool += specialCharacters;
        }

        // Ensure at least one character type is selected
        if (characterPool.isEmpty()) {
            throw new IllegalArgumentException("At least one character type must be selected.");
        }

        // Randomly generate the password
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the desired password length from the user
        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();

        // Get user preferences for character types
        System.out.print("Include uppercase letters? (true/false): ");
        boolean useUppercase = scanner.nextBoolean();

        System.out.print("Include lowercase letters? (true/false): ");
        boolean useLowercase = scanner.nextBoolean();

        System.out.print("Include numbers? (true/false): ");
        boolean useNumbers = scanner.nextBoolean();

        System.out.print("Include special characters? (true/false): ");
        boolean useSpecial = scanner.nextBoolean();

        // Generate and display the password
        try {
            String password = generatePassword(length, useUppercase, useLowercase, useNumbers, useSpecial);
            System.out.println("Generated password: " + password);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
