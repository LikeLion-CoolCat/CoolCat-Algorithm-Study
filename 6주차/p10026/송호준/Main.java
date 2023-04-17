import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static char[][] board;
    private static int cnt3Color;
    private static int cnt2Color;
    private static boolean[][] visited;
    private static int[] dX = {-1, 0, 1, 0};
    private static int[] dY = {0, -1, 0, 1};
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    BFS(new Point(i, j), board[i][j]);
                    cnt3Color++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'G') {
                    board[i][j] = 'R';
                }
            }
        }
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    BFS(new Point(i, j), board[i][j]);
                    cnt2Color++;
                }
            }
        }
        System.out.println(cnt3Color + " " + cnt2Color);
    }

    private static void BFS(Point start, char color) {
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dX[i];
                int nextY = now.y + dY[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
                    continue;
                }
                if (!visited[nextX][nextY] && board[nextX][nextY] == color) {
                    q.add(new Point(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }
    }
}
