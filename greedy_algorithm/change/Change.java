import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //write your code here
        int i = 0 , j = 0, k = 0;
        i = m / 10;
        j = (m - i * 10) / 5;
        k = m - i * 10 - j * 5;
        return i + j + k;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

