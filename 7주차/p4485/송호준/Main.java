import java.io.*;
import java.util.*;

public class Main {
    private static class Point {
        int x;
        int y;
        int cost;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    private static int N;
    private static int[][] graph;
    private static boolean[][] visited;
    private static final int[] dX = {0, 1, -1, 0};
    private static final int[] dY = {1, 0, 0, -1};
    private static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int round = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            graph = new int[N][N];
            dist = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
            dist[0][0] = graph[0][0];

            Dijkstra(new Point(0, 0, dist[0][0]));
            sb.append("Problem ").append(round++).append(": ").append(dist[N - 1][N - 1]).append("\n");
        }
        System.out.println(sb);
    }

    private static void Dijkstra(Point start) {
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(start);
        visited[0][0] = true;
        while (!pq.isEmpty()) {
            Point now = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dX[i];
                int nextY = now.y + dY[i];
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                    if (visited[nextX][nextY]) {
                        continue;
                    }
                    if (dist[now.x][now.y] + graph[nextX][nextY] < dist[nextX][nextY]) {
                        dist[nextX][nextY] = dist[now.x][now.y] + graph[nextX][nextY];
                        visited[nextX][nextY] = true;
                        pq.add(new Point(nextX, nextY, dist[nextX][nextY]));
                    }
                }
            }
        }
    }
}
