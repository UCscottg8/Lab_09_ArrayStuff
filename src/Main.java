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

    public static int min(int[] values) {
        int minValue = values[0];
        for (int value : values) {
            if (value < minValue) {
                minValue = value;
            }
        }
        return minValue;
    }

    public static int max(int[] values) {
        int maxValue = values[0];
        for (int value : values) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    public static int occuranceScan(int[] values, int target) {
        int count = 0;
        for (int value : values) {
            if (value == target) {
                count++;
            }
        }
        return count;
    }

    public static int sum(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    public static boolean contains(int[] values, int target) {
        for (int value : values) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] dataPoints = new int[100];
        Random rand = new Random();

        // Initialize array with random values
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rand.nextInt(100) + 1;
        }

        // Print min, max, sum and whether a user value is contained in the array
        System.out.println("Min value: " + min(dataPoints));
        System.out.println("Max value: " + max(dataPoints));
        System.out.println("Sum: " + sum(dataPoints));

        // Prompt and input an int value between 1 and 100 from the user
        Scanner scanner = new Scanner(System.in);
        int userValue = SafeInput.getRangedInt(scanner, "Enter a number between 1 and 100", 1, 100);

        System.out.println("The value " + userValue + " occurs " + occuranceScan(dataPoints, userValue) + " times in the array.");
        System.out.println("The array contains user value: " + contains(dataPoints, userValue));
    }
}
