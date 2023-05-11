import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int func = Integer.parseInt(st.nextToken());

        boolean[] visited;
        if (func == 1) {
            StringBuilder answer1 = new StringBuilder();
            visited = new boolean[n + 1];
            long k = Long.parseLong(st.nextToken());
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (!visited[j]) {
                        if (k > factorial(n - i - 1)) {
                            k -= factorial(n - i - 1);
                        } else {
                            answer1.append(j).append(" ");
                            visited[j] = true;
                            break;
                        }
                    }
                }
            }
            System.out.println(answer1);
        } else {
            long answer2 = 1;
            visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                int value = Integer.parseInt(st.nextToken());
                for (int j = 1; j < value; j++) {
                    if (!visited[j]) {
                        answer2 += factorial(n - i);
                    }
                }
                visited[value] = true;
            }
            System.out.println(answer2);
        }
    }

    private static long factorial(int k) {
        long s = 1;
        for (int i = 1; i <= k; i++) {
            s *= i;
        }
        return s;
    }
}
