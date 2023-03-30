import java.util.Arrays;
import java.util.Scanner;

public class P1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nArr = new int[N];
        for (int i = 0; i < N; i++) {
            nArr[i] = sc.nextInt();
        }
        Arrays.sort(nArr);

        int M = sc.nextInt();

        for (int i = 0; i < M; i++) {
            boolean B = false;
            int num = sc.nextInt();

            int start = 0;
            int end = nArr.length - 1;

            while (start <= end) {
                int mid = (start + end) / 2;
                if (nArr[mid] > num) {
                    end = mid - 1;
                } else if (nArr[mid] < num) {
                    start = mid + 1;
                } else {
                    B = true;
                    break;
                }
            }
            
            if (B) {
                System.out.println(1);
            } else System.out.println(0);
        }
    }
}

