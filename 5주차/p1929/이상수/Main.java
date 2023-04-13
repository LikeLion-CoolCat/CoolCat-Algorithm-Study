import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // [BOJ] n : 1929 결과는 나오는데 시간초과
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for (int i = m; i < n; i++) {
            if(checkNumber(i)){
                System.out.println(i);
            }
        }
    }

    static boolean checkNumber(int n) {
        for (int i = 2; i + i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
