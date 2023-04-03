import java.util.Scanner;

public class Main { // [BOJ] 11047
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        int money = k; // money가 k와 같을 때 종료
        int remain = 0; // 나머지
        int quotient = 0; // 몫

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        //구현부
        //while(true){ // 계속 돈을 증가시켜서 k와 같을 때 종료
        for (int i = n - 1; i >= 0; i--) {
            if (money / a[i] >= 1) {// 몫이 하나라도 나올 때
                count += (money / a[i]);
                money %= a[i];

            }
            if (i == 0) {
                count += money;
            }
        }
        //}
        System.out.println(count);
    }
}
