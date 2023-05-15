import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];
        int N = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            N += arr[i];
        }
        int K = Integer.parseInt(br.readLine());

        double sum = 0;
        for (int cnt : arr) {
            if (cnt >= K) {
                sum += combination2(cnt, K);
            }
        }
        double answer = sum / combination2(N, K);
        System.out.println(answer);
    }

    private static double combination2(int N, int K) {
        double x = 1;
        for (int i = 0; i < K; i++) {
            x *= (N - i);
        }
        return x;
    }
}
