import java.io.*;
import java.util.*;

//https://velog.io/@topqr123q/%EB%B0%B1%EC%A4%80-2293%EB%B2%88-%EC%9E%90%EB%B0%94 참고

public class Main {
    static int n,k;
    static int[] num;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        num = new int[n+1];
        dp = new int[k+1];
        dp[0] = 1;

        for(int i=1; i<=n; i++) {
            num[i] = Integer.parseInt(bf.readLine());
            for(int j=num[i]; j<=k; j++){
                dp[j] += dp[j-num[i]];
            }
        }

        System.out.println(dp[k]);
    }
}
