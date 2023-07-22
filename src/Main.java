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

        // Find the minimum and maximum value in the array
        int minValue = dataPoints[0];
        int maxValue = dataPoints[0];
        for (int i = 1; i < dataPoints.length; i++) {
            if (dataPoints[i] < minValue) {
                minValue = dataPoints[i];
            }
            if (dataPoints[i] > maxValue) {
                maxValue = dataPoints[i];
            }
        }
        System.out.println("The minimum value in the array is: " + minValue);
        System.out.println("The maximum value in the array is: " + maxValue);

        // Prompt and input an int value between 1 and 100 from the user
        Scanner scanner = new Scanner(System.in);
        int userValue = SafeInput.getRangedInt(scanner, "Enter a number between 1 and 100", 1, 100);

        // Find the first occurrence of the user’s value in the array
        boolean found = false;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userValue) {
                System.out.println("The value " + userValue + " was found at array index " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("The value " + userValue + " was not found in the array.");
        }
    }
}
