package 백준.Baekjoon1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[] visited;
    static int N;
    static void dfs(int node){
        System.out.print(node+" ");
        visited[node] = true;

        for(int i=1; i<=N; i++){
            if(!visited[i] && graph[node][i]==1){
                dfs(i);
            }
        }
    }

    static void bfs(int node){
        boolean[] visited2 = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited2[node] =  true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr+" ");

            for(int i=1; i<=N; i++){
                if(!visited2[i] && graph[curr][i] == 1){
                    visited2[i] = true;
                    q.add(i);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        dfs(start);
        System.out.println();
        bfs(start);
    }
}
