import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            boolean isPresent = binarySearch(key, 0, N - 1);
            if (isPresent) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean binarySearch(int key, int startIdx, int endIdx) {
        while (startIdx <= endIdx) {
            int midIdx = (startIdx + endIdx) / 2;
            if (arr[midIdx] == key) {
                return true;
            } else if (arr[midIdx] > key) {
                endIdx = midIdx - 1;
            } else {
                startIdx = midIdx + 1;
            }
        }
        return false;
    }
}
