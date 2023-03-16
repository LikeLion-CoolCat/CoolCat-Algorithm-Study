import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(1);
            return;
        }
        int answer;
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }
        while (true) {
            q.poll();
            if (q.size() == 1) {
                answer = q.poll();
                break;
            }
            int tmp = q.poll();
            q.add(tmp);
        }
        System.out.println(answer);
    }
}
