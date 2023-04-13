import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int r = GCD(A, B);
            sb.append(A * B / r).append("\n");
        }
        System.out.println(sb);
    }

    private static int GCD(int a, int b) {
        int r = a % b;
        if (r == 0) {
            return b;
        }
        return GCD(b, r);
    }
}
