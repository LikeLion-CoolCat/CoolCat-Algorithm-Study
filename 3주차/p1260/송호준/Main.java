import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static int N;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        DFS(V);
        sb.append("\n");
        BFS(V);
        System.out.println(sb);

    }

    private static void DFS(int start) {
        sb.append(start).append(" ");
        visited[start] = true;
        for (int i = 1; i <= N; i++) {
            if (graph.get(start).contains(i) && !visited[i]) {
                DFS(i);
            }
        }
    }

    private static void BFS(int start) {
        visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int k = q.poll();
            sb.append(k).append(" ");
            for (int i = 1; i <= N; i++) {
                if (graph.get(k).contains(i) && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
