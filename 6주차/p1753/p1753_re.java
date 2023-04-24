package p1753;

import java.util.*;

public class p1753_re {

    static class Edge implements Comparable<Edge> {

        //목적지, 가중치
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(weight, o.weight);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(); // 정점의 개수
        int E = sc.nextInt(); // 간선의 개수
        int K = sc.nextInt(); // 시작 정점의 번호

        // STEP1. 그래프 구현하기
        ArrayList<Edge>[] graph = new ArrayList[V + 1]; // 그래프를 그릴 곳 (1 ~ 정점 개수 +1, 0은 X)

        for (int i = 1; i <= V; i++)
        {
            graph[i] = new ArrayList<>(); // 정보 초기화
        }

        // 각 간선을 나타내는 세 개의 정수(u, v, w)
        for (int i = 0; i < E; i++)
        {
            int u = sc.nextInt(); // 시작 정점 번호 (From)
            int v = sc.nextInt(); // 도착 정점 번호 (To)
            int w = sc.nextInt(); // 가중치 (Weight)

            graph[u].add(new Edge(v, w));
        }

        // STEP2. 최단 거리 배열 초기화하기
        int[] distance = new int[V + 1]; // 거리를 저장
        Arrays.fill(distance, Integer.MAX_VALUE); // 거리를 모두 무한대로 설정
        distance[K] = 0; // 단, 시작 지점은 0으로 함

        // STEP3. 우선순위 큐를 이용한 다익스트라 알고리즘
        PriorityQueue<Edge> pq = new PriorityQueue<>(); //우선순위 큐 -> 가중치가 가장 작은 간선을 우선 처리
        pq.add(new Edge(K, 0)); // 시작 정점과 가중치 0을 우선순위 큐에 삽입

        while (!pq.isEmpty())
        {
            Edge current = pq.poll(); // 가장 가중치가 작은 간선을 선택
            int cur = current.to;

            // 이미 처리된 정점이면 continue
            if (distance[cur] < current.weight) {
                continue;
            }

            //현재 위치에서 연결된(다음으로 이어질 수 있는) 간선들을 모두 순회
            for (Edge next : graph[cur])
            {
                int nextTo = next.to;
                int nextWeight = current.weight + next.weight;

                // 다음에 갈 정점까지의 거리가 더 짧은 경우를 발견할 경우 갱신
                if (distance[nextTo] > nextWeight)
                {
                    distance[nextTo] = nextWeight;
                    pq.add(new Edge(nextTo, nextWeight)); // 우선순위 큐에 다음 간선 삽입
                }
            }
        }

        // 정점 별로 출력(경로가 없으면 INF)
        for (int i = 1; i <= V; i++)
        {
            if (distance[i] == Integer.MAX_VALUE)
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
