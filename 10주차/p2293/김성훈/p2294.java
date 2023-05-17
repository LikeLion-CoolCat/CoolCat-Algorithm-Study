package p2293;

import java.util.Arrays;
import java.util.Scanner;

public class p2294 {

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

        int result = 0;

        //dp = 각 i 원을 만들기 위한 방법의 수 배열
        int[] dp = new int[k + 1];
        Arrays.fill(dp, k+1);
        dp[0] = 0;


        for(int i=0; i<coins.length; i++)
        {
            int now_coin = coins[i];

            for(int j=now_coin; j <= k; j++)
            {
                //어떤 경우가 더 작은 동전 개수로 목표값을 만들어낼 수 있는가?
                dp[j] = Math.min(dp[j], dp[j - now_coin] + 1);
            }
        }

        //만들 수 있는 경우, 아닌 경우
        //(초기에 k+1 로 초기화한게 갱신되지 않은 경우 -1 반환)
        if(dp[k] > k){
            result = -1;
        }
        else {
            result = dp[k];
        }

        return result;
    }

}
