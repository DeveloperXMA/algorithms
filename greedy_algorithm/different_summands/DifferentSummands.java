import java.util.*;

public class DifferentSummands {

    // l represent the minimum summand
    // k represent the sum
    // ofcourse, l <= k
    private static void magic(int l, int k, List<Integer> summands) {
        if (k <= 0) return;
//        if ( k <= 2l) {
//            summands.add(k);
//        } else {
//            summands.add(l);
//            magic( l + 1, k - l, summands);
//        }
        while (k > 0) {
            if ( k <= (2 * l)) {
                summands.add(k);
                break;
            } else {
                summands.add(l);
                k = k - l;
                l = l + 1;
            }
        }
    }

    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        //write your code here
        magic(1, n, summands);
        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

