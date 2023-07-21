import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] dataPoints = new int[100];
        Random rand = new Random();

        // Initialize array with random values
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rand.nextInt(100) + 1;
        }

        // Output statement - Print array values
        for (int i = 0; i < dataPoints.length; i++) {
            if (i != dataPoints.length - 1) {
                System.out.print(dataPoints[i] + " | ");
            } else {
                System.out.print(dataPoints[i]); // avoid trailing "|" at the end
            }
        }
        System.out.println(); // add a new line for readability

        // Calculate sum and average
        double sum = 0.0;
        for (int i = 0; i < dataPoints.length; i++) {
            sum += dataPoints[i];
        }
        double average = sum / dataPoints.length;

        // Output statement - Print sum and average
        System.out.printf("The sum of the values in the dataPoints array is: %.2f\n", sum);
        System.out.printf("The average of the values in the dataPoints array is: %.2f\n", average);
    }
}
