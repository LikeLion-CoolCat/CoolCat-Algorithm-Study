package p2293;

import java.util.Arrays;
import java.util.Scanner;

public class p2293 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] coins = new int[n];

        for(int i=0; i<n; i++) {
            coins[i] = sc.nextInt();
        }

        int result = dynamic(k, coins);

        System.out.println(result);

    }

    public static int dynamic(int k, int[] coins){

        //dp = 각 i 원을 만들기 위한 방법의 수 배열
        int[] dp = new int[k + 1];

        dp[0] = 1;


        for(int i=0; i<coins.length; i++)
        {
            int now_coin = coins[i];

            //A += B
            //ex) 이전에 B를 만들어 두었다면, A를 만들때 해당 경우의 수를 사용할 수 있음(갱신)
            for(int j=now_coin; j <= k; j++)
            {
                dp[j] += dp[j - now_coin];
            }
        }

        //k를 만들기 위한 방법의 수는?
        return dp[k];
    }

}
