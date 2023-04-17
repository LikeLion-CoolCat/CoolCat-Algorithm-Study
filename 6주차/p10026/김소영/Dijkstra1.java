import java.util.*;

// https://girawhale.tistory.com/21 의 코드를 참고
public class Main {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static char[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int answer[] = {0, 0};
        map = new char[size][size];
        for (int i = 0; i < size; i++)
            map[i] = sc.next().toCharArray(); // String을 char배열로 바꾸어주는 메소드

        boolean[][][] visit = new boolean[2][size][size];

        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (!visit[k][i][j]) {
                        dfs(i, j, visit[k], map[i][j]);
                        answer[k]++;
                    }
                    if (map[i][j] == 'G')
                        map[i][j] = 'R';
                }
            }
        }
        System.out.println(answer[0] + " " + answer[1]);

    }

    static void dfs(int y, int x, boolean[][] visit, char ch) {
        visit[y][x] = true;

        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];

            if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] || map[ny][nx] != ch)
                continue;
            dfs(ny, nx, visit, ch);
        }
    }
}
