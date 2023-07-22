import java.util.Random;
import java.util.Scanner;

public class Main {
    public static class SafeInput {
        public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
            int value;
            do {
                System.out.printf("\n%s [%d-%d]: ", prompt, low, high);
                while (!pipe.hasNextInt()) {
                    System.out.println("That's not a number! Try again.");
                    pipe.next();
                }
                value = pipe.nextInt();
                pipe.nextLine(); // Clear the newline character
            } while (value < low || value > high);
            return value;
        }
    }

    public static void main(String[] args) {
        int[] dataPoints = new int[100];
        Random rand = new Random();

        // Initialize array with random values
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rand.nextInt(100) + 1;
        }

        // Print array values
        for (int i = 0; i < dataPoints.length; i++) {
            if (i != dataPoints.length - 1) {
                System.out.print(dataPoints[i] + " | ");
            } else {
                System.out.print(dataPoints[i]);
            }
        }
        System.out.println();

        // Calculate sum and average
        double sum = 0.0;
        for (int i = 0; i < dataPoints.length; i++) {
            sum += dataPoints[i];
        }
        double average = sum / dataPoints.length;

        // Print sum and average
        System.out.printf("The sum of the values in the dataPoints array is: %.2f\n", sum);
        System.out.printf("The average of the values in the dataPoints array is: %.2f\n", average);

        // Prompt and input an int value between 1 and 100 from the user
        Scanner scanner = new Scanner(System.in);
        int userValue = SafeInput.getRangedInt(scanner, "Enter a number between 1 and 100", 1, 100);

        // Count how many times the user’s value is found within the array
        int count = 0;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userValue) {
                count++;
            }
        }

        // Print the count
        System.out.println("Your number " + userValue + " appears " + count + " times in the array.");
    }
}
