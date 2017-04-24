import java.util.Scanner;

public class FractionalKnapsack {

    private static double[][] sortArray(double[][] array) {
        for (int i = 0; i < array.length - 1; i++) {
            double max = array[i][2];
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (max < array[j][2]) {
                    max = array[j][2];
                    index = j;
                }
            }
            if (max > array[i][2]) {
               double[] temp = array[index];
               array[index] = array[i];
               array[i] = temp;
            }
        }
        return array;
    }

    private static double[][] sort(int[] values, int[] weights) {
        double[][] newArray = new double[values.length][3];
        for (int i = 0; i < values.length; i++) {
            newArray[i][0] = (double)values[i];
            newArray[i][1] = weights[i];
            newArray[i][2] = (newArray[i][0] / newArray[i][1]) * 1000.0 / 1000.0000;
        }
        return sortArray(newArray);
    }

    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0.0;
        //write your code here
        double[][] sorted = new double[values.length][3];
        sorted = sort(values, weights);
        int leftCapacity = capacity;
        for (int i = 0; i < sorted.length; i++) {
            if (leftCapacity > 0) {
                if (sorted[i][1] > leftCapacity) {
                    value += leftCapacity * sorted[i][2];
                    leftCapacity = 0;
                } else {
                    value += sorted[i][0];
                    leftCapacity = leftCapacity - (int)sorted[i][1];
                }
            } else {
                break;
            }
        }
        value = (double)Math.round(value * 10000d) / 10000d;
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
