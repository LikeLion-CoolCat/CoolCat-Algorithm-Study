import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] price = new int[n];
        int[] dp = new int[k+1];

        dp[0] = 1;

        for(int i=0; i<n; i++){
            price[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j >= price[i])
                    dp[j] += dp[j - price[i]];
            }
        }

        System.out.println(dp[k]);

    }
}
