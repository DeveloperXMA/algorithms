import java.util.*;

public class LargestNumber {
    // return which str1 should be used, aka, the safe str, the safe move
    private static String magic(String str1, String str2) {
      int a = Integer.parseInt(str1 + str2);
      int b = Integer.parseInt(str2 + str1);
      return a > b ? str1 : str2;
    }

    private static String[] Splice(String[] strArray, String str) {
        if (strArray.length == 1) {
            return strArray;
        }
        int index = 0;
        boolean oneTimeEach = false;
        String[] tempArray = new String[strArray.length - 1];
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i] != str || oneTimeEach) {
                tempArray[index++] = strArray[i];
            } else {
                oneTimeEach = true;
            }
        }
        return tempArray;
    }

    private static String magic2(String[] a, String result) {
        if (a.length == 1) {
            result += a[0];
            return result;
        }
        String safeResult = a[0];
        for (int i = 0; i < a.length - 1; i++) {
            String temp = magic(a[i], a[i+1]);
            safeResult = magic(safeResult, temp);
        }
        result += safeResult;
        a = Splice(a, safeResult);
        result = magic2(a, result);
        return result;
    }

    private static String largestNumber(String[] a) {
        //write your code here
        String result = "";
        result = magic2(a, result);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}
