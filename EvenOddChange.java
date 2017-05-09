import java.util.*;

public class EvenOddChange {

    // put all even integer before odd integer in array
    // keep all integer in same order
    // use O(1) space
    // use O(n) time complexity
    private static void long sawp(int[] array) {
        //write your code here
        if (this.oddIndex >= array.length || this.evenIndex >= array.length) return;
        while (array[oddIndex++] % 2 == 0) {
          // change oddIndex to next first odd digit in array
        }
        while (array[evenIndex] % 2 != 0) {
          // move evenIndex to next first even digit in array
        }

    }

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int n = scanner.nextInt();
       int[] a = new int[n];
       for (int i = 0; i < n; i++) {
           a[i] = scanner.nextInt();
       }
       int oddIndex = 0, evenIndex = 0;
       System.out.println(swap(a));
    }
}
