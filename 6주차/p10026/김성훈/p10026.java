package p10026;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p10026 {

    //bfs에서도 사용하기 위함
    public static int n;
    public static char[][] input_color;
    public static boolean[][] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        input_color = new char[n][n];

        for(int i=0; i<n; i++)
        {
            String input = sc.next();
            //System.out.println(" ");
            for(int j=0; j<n; j++)
            {
                input_color[i][j] = input.charAt(j);
                //System.out.printf("%c",input_color[i][j]);
            }
        }

        int normal_sight = 0;
        int abnormal_sight = 0;

        //시작 전 방문 초기화
        visited = new boolean[n][n];

        //색약이 아닌 경우( R, G, B 영역 )
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(!visited[i][j])
                {
                    bfs(i, j, input_color[i][j]);
                    normal_sight++;
                }
            }
        }

        //시작 전 방문 초기화
        visited = new boolean[n][n];

        //색약인 경우 ( R(=G), B 영역 )
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(input_color[i][j] == 'G')
                {
                    input_color[i][j] = 'R';
                }
            }
        }

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(!visited[i][j])
                {
                    bfs(i, j, input_color[i][j]);
                    abnormal_sight++;
                }
            }
        }

        System.out.printf("%d %d \n", normal_sight, abnormal_sight);

    }

    public static void bfs(int x, int y, char color)
    {
        Queue<int[]> bfs_queue = new LinkedList<>();

        //각 시작점 등록, 시작은 방문처리
        bfs_queue.offer(new int[] {x,y});
        visited[x][y] = true;

        //상, 하, 좌, 우
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        while(!bfs_queue.isEmpty())
        {
            int[] cur = bfs_queue.poll();
            int pointX = cur[0];
            int pointY = cur[1];

            for(int[] dir : directions)
            {
                int nx = pointX + dir[0];   //0, 0, -1, 1
                int ny = pointY + dir[1];   //1, -1, 0, 0

                //인덱스는 0 미만으로 이동할 수 없고, n보다 큰 범위는 접근하지 않도록 한다.
                //또, 방문하지 않았어야 하며, 시작점과 색이 같아야 한다(영역이 되어야 한다)
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && input_color[nx][ny] == color)
                {
                    visited[nx][ny] = true;
                    bfs_queue.offer(new int[] {nx, ny});
                }
            }
        }
    }
}
