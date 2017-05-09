import java.util.*;

public class DotProduct {

    private static void merge(int[] data, int start, int mid, int end) {
      int[] temp = new int[data.length];
      int start1 = start, end1 = mid;
      int start2 = mid + 1, end2 = end;
      int index = start;
      while (start1 <= end1 && start2 <= end2 ) {
        temp[index++] = (data[start1] > data[start2]) ? data[start1++] : data[start2++];
      }
      while (start1 <= end1) {
        temp[index++] = data[start1++];
      }
      while (start2 <= end2) {
        temp[index++] = data[start2++];
      }
      for (int i = start; i <= end; i++) {
        data[i] = temp[i];
      }
    }

    private static void sort(int[] data, int start, int end) {
      if (start >= end) return;
      int length = end - start;
      int mid = (length >> 1) + start;
      int start1 = start;
      int end1 = mid;
      int start2 = mid + 1;
      int end2 = end;
      sort(data, start1, end1);
      sort(data, start2, end2);
      merge(data, start, mid, end);
    }

    private static void mergeSort(int[] data) {
      sort(data, 0, data.length - 1);
    }

    private static long maxDotProduct(int[] a, int[] b) {
        //write your code here
        mergeSort(a);
        mergeSort(b);
        long result = 0;
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
            System.out.println(b[i]);
            result += a[i] * b[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}
