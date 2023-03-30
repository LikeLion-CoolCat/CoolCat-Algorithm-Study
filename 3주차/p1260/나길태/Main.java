package com.ll.BOJ.탐색;

import java.util.*;

public class P1260 {
  // 미완성
    static boolean[] visit; //방문노드기록
    static ArrayList<Integer>[] aList; //그래프

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //노드 갯수
        int m = sc.nextInt(); //엣지 갯수
        int start = sc.nextInt(); //시작점

        aList = new ArrayList[n+1];

        for(int i=1; i< n; i++){
            aList[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            aList[s].add(e);
            aList[e].add(s);
        }

        for(int i=1; i<=n; i++){
            Collections.sort(aList[i]);
        }

        visit = new boolean[n+1];
        DFS(start);
        System.out.println();
        visit = new boolean[n+1];
        BFS(start);
        System.out.println();
    }

    public static void DFS(int node){
        visit[node] = true;
        for(int i : aList[node]){
            if(!visit[i]){
                DFS(i); //재귀
            }
        }
    }

    public static void BFS(int node){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visit[node] = true;
        while(!queue.isEmpty()){
            int now_node = queue.poll();
            System.out.println(now_node + " ");
            for(int i: aList[now_node]){
                if(!visit[i]){
                    visit[i] = true;
                    queue.add(i);
                }
            }
        }

    }
}
