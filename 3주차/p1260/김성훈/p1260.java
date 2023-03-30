package p1260;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p1260 {

    static int[][] arr;
    static boolean[] visited;
    static int n;
    static int m;
    static int v;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();       //정점의 개수
        m = sc.nextInt();       //간선의 개수
        v = sc.nextInt();       //시작 정점

        arr = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=m; i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();

            //양방향 연결
            arr[x][y] = arr[y][x] = 1;
        }

        dfs(v);

        System.out.println("-".repeat(30));

        //방문내역 초기화
        visited = new boolean[n+1];

        bfs(v);

        sc.close();
    }

    //깊이 우선 탐색(DFS) - 스택 or 재귀(여기선 재귀)
    public static void dfs(int start_node)
    {
        //시작 노드는 방문 O로 처리
        visited[start_node] = true;

        System.out.println("dfs_node = " + start_node);

        for(int i=0; i<n+1; i++)
        {
            //인접한 노드중 방문하지 않은 노드가 있다면 재귀.
            //인접한 노드중에선 다 방문했다면 해당 문이 종료되고, 재귀에 의해 거슬러 올라가서 또 탐색하게됨.
            if(arr[start_node][i]==1 && !visited[i])
            {
                dfs(i);
            }
        }
    }

    //넓이 우선 탐색(BFS)
    public static void bfs(int start_node)
    {
        Queue<Integer> bfs_graph = new LinkedList<>();

        //시작 노드를 큐에 집어넣음
        bfs_graph.offer(start_node);

        //첫 노드는 방문처리
        visited[start_node] = true;

        //모든 노드가 탐색될때까지 무한반복
        while(!bfs_graph.isEmpty())
        {
            //큐는 FIFO
            int get = bfs_graph.poll();

            System.out.println("bfs_visited = " + get);

            for(int i=0; i<arr[get].length; i++)
            {
                //방문을 이미 했거나 / 연결되지 않았다면 넘어감.
                if(visited[i] || arr[get][i] <1)
                    continue;

                //방문도 안했는데 연결되어있다면
                bfs_graph.offer(i);     //인접 노드를 큐에 추가.
                visited[i] = true;      //방문
            }
        }

    }
}
