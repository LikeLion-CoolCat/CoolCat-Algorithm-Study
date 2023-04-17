import java.util.ArrayList;
import java.util.Scanner;

public class Main { //[BOJ] 1934 최소공배수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int result = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            result = gcd(a, b);

            list.add(a * b / result);

        }

        for (int i = 0; i < n; i++) {
            System.out.println(list.get(i));
        }
    }
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        else {
            return gcd(b, a % b);
        }
    }
}
