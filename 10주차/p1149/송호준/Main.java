import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] dp = new int[N][3];

        st = new StringTokenizer(br.readLine());
        dp[0][0] = Integer.parseInt(st.nextToken());
        dp[0][1] = Integer.parseInt(st.nextToken());
        dp[0][2] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + Integer.parseInt(st.nextToken());
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + Integer.parseInt(st.nextToken());
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + Integer.parseInt(st.nextToken());
        }
        System.out.println(Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]));
    }
}
