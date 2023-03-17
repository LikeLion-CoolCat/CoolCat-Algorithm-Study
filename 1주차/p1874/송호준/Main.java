import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        int max = 0;
        int ptr = 1;
        stack.add(0);
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            max = Math.max(number, max);
            int now = stack.peek();
            if (number > now) {
                if (max > number) {
                    sb = new StringBuilder();
                    sb.append("NO");
                    break;
                }
                while (stack.peek() != number) {
                    stack.add(ptr);
                    ptr++;
                    sb.append("+").append("\n");
                }
            } else if (number < now) {
                while (stack.peek() != number) {
                    if (stack.isEmpty()) {
                        sb = new StringBuilder();
                        sb.append("NO");
                        break;
                    }
                    stack.pop();
                    sb.append("-").append("\n");
                }

            }
            if (number == stack.peek()) {
                stack.pop();
                sb.append("-").append("\n");
            }
        }
        System.out.println(sb);
    }
}
