package p1753;

import java.util.*;

public class p1753 {

    static class Edge {

        //목적지, 가중치
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();   //정점의 개수
        int E = sc.nextInt();   //간선의 개수
        int K = sc.nextInt();   //시작 정점의 번호

        //STEP1. 그래프 구현하기
        ArrayList<Edge>[] graph = new ArrayList[V+1];       //그래프를 그릴 곳 (1 ~ 정점 개수 +1, 0은 X)

        for(int i=1; i<= V; i++)
        {
            graph[i] = new ArrayList<>();       //정보 초기화
        }

        //각 간선을 나타내는 세 개의 정수(u, v, w)
        for(int i=0; i<E; i++)
        {
            int u = sc.nextInt();       //시작 정점 번호 (From)
            int v = sc.nextInt();       //도착 정점 번호 (To)
            int w = sc.nextInt();       //가중치 (Weight)

            graph[u].add(new Edge(v, w));
        }

        //STEP2. 최단 거리 배열 초기화하기
        int[] distance = new int[V+1];                  //거리를 저장
        Arrays.fill(distance, Integer.MAX_VALUE);       //거리를 모두 무한대로 설정
        distance[K] = 0;                                //단, 시작 지점은 0으로 함


        boolean[] visited = new boolean[V+1];           //방문 기록, 초기화

        //STEP3. 순회 하면서 최단거리 구하기
        //모든 정점을 방문하면서 각 정점에서 시작하는 최단 경로를 구함
        for(int i=1; i<=V; i++)
        {
            int current = -1;
            int minDistance = Integer.MAX_VALUE;

            for(int j=1; j<=V; j++)
            {
                //방문하지 않은 정점들 중에 더 짧은 거리를 가진 정점이 있는가?
                if(!visited[j] && distance[j] < minDistance)
                {
                    current = j;
                    minDistance = distance[j];
                }
            }

            //더 이상 방문 가능한 곳이 없었을 경우 종료
            if(current == -1)
                break;

            //방문 처리
            visited[current] = true;

            //STEP4. 최단거리를 점검하며 배열 완성하기
            for(int q=0; q<graph[current].size(); q++)
            {
                //현재 위치에서 다음에 갈 곳(To)은?
                int next = graph[current].get(q).to;

                //To 로의 거리는?
                int weight = graph[current].get(q).weight;

                //현재 위치에서 다음으로 이동하는 것 보다 빠른 경로를 이전에 알고있었는가?
                if(distance[next] > distance[current] + weight)
                {
                    //몰랐다면 최단경로 갱신
                    distance[next] = distance[current] + weight;
                }
            }
        }

        //정점 별로 출력(경로가 없으면 INF)
        for(int i=1; i<=V; i++)
        {
            if(distance[i] == Integer.MAX_VALUE)
            {
                System.out.println("INF");
            }
            else
            {
                System.out.println(distance[i]);
            }
        }
    }
}
