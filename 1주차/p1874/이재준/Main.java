package 백준.Baekjoon1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/**
 * https://www.acmicpc.net/problem/1874
 * 백준 1874
 * 문제풀이 : 스택
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int currenNum = 0;

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            if (currenNum < n) {
                for (int i = currenNum + 1; i <= n; i++) {
                    stack.push(i);
                    sb.append("+\n");
                    currenNum = i;
                }
                stack.pop();
                sb.append("-\n");
            } else {
                if (stack.pop() == n) {
                    sb.append("-\n");
                } else {
                    System.out.println("NO");
                    System.exit(0);
                }
            }
        }
        System.out.println(sb);
    }
}
