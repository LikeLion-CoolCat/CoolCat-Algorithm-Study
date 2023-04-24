package p4485;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class p4485 {

    //동굴의 크기
    static int N;

    //(수학의 좌표가 아닌 배열의 축으로 생각해야함)
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static int[][] cost;                //각 비용 정리
    static boolean[][] visited;         //방문 여부

    static int problemCount = 1;        //몇 번째 해결?

    //x(From)에서 y(To)로 가는데 얼마가 드는지(Cost) 정리
    static class Course implements Comparable<Course> {

        int x, y, cost;

        public Course(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Course o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true) {
            N = sc.nextInt();

            if (N == 0) {
                break;
            }

            visited = new boolean[N][N];
            cost = new int[N][N];

            int[][] cave = new int[N][N];

            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    cave[i][j] = sc.nextInt();
                }
                Arrays.fill(cost[i], Integer.MAX_VALUE);
            }
            cost[0][0] = cave[0][0];

            explore(cave);
        }
    }

    static void explore(int[][] cave)
    {
        //가중치가 작은 것부터 시작하는 PQ 생성, 0번부터 시작
        PriorityQueue<Course> pq = new PriorityQueue<>();
        pq.add(new Course(0, 0, cave[0][0]));

        while(!pq.isEmpty())
        {
            Course path = pq.poll();
            int x = path.x;
            int y = path.y;

            //이미 방문했다면 넘어감
            if(visited[x][y]){
                continue;
            }

            //방문 처리
            visited[x][y] = true;

            //4인 이유 -> 동 서 남 북
            for(int i=0; i<4; i++)
            {
                int nx = x + dx[i];
                int ny = y + dy[i];

                //현재 위치에서 동, 서, 남, 북을 둘러봤을 때, 인덱스를 벗어나지 않는가?
                if(nx >= 0 && nx < N && ny >= 0 && ny < N)
                {
                    //(동, 서, 남, 북) 에 방문하지 않은 곳이 있다면
                    if(!visited[nx][ny])
                    {
                        int current_cost = cave[nx][ny];

                        //전에 동서남북으로 이동했던 경로에 대한 값이 저장되어 있는데,
                        //이번에 진행되는 경로가 이전의 경로 비용보다 적게 든다면
                        if(cost[nx][ny] > cost[x][y] + current_cost)
                        {
                            //갱신 후 PQ에 경로 추가
                            cost[nx][ny] = cost[x][y] + current_cost;
                            pq.add(new Course(nx, ny, cost[nx][ny]));
                        }
                    }
                }
            }
        }
        System.out.printf("Problem %d: %d\n",problemCount, cost[N-1][N-1]);
        problemCount++;
    }
}
