package p1260;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class p1260 {

    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();       //노드의 개수
        int m = sc.nextInt();       //간선의 개수
        int v = sc.nextInt();       //시작 노드

        //인덱스를 1부터 사용하기 위함.
        graph = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=0; i<n; i++)
        {
            //양방향 그래프로 설정함.
            int from = sc.nextInt();
            int to = sc.nextInt();

            graph[from][to] = graph[to][from] = 1;
        }

        dfs(v);

        //방문 순서대로 출력?

        sc.close();
    }

    public static void dfs(int node)
    {
        visited[node] = true;       //시작 노드는 방문 o

        for(int i=0; i<graph[node].length; i++)
        {
            //주변 노드 탐색
            int adjNode = graph[node][i];

            //방문하지 않은 주변 노드가 있다면 방문 -> 그 자리부터 재귀
            if(!visited[adjNode])
            {
                dfs(adjNode);
            }
        }
    }
}
