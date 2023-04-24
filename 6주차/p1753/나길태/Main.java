import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static int V, E, K;
    public static int distance[]; // 가중치 저장 배열
    public static boolean visited[]; //방문확인 배열
    public static ArrayList<Edge> list[]; //인접리스트
    public static PriorityQueue<Edge> q =new PriorityQueue<Edge>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); //노드 갯수
        E = Integer.parseInt(st.nextToken()); //엣지 갯수
        K = Integer.parseInt(br.readLine());  // 시작 노드

        distance = new int[V + 1];
        visited = new boolean[V + 1];
        list = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++)
            list[i] = new ArrayList<Edge>();

        for (int i = 0; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) { // 가중치가 있는 인접 리스트 초기화하기
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v, w));
        }

        q.add(new Edge(K, 0));
        distance[K] = 0;


        while (!q.isEmpty()) {

            Edge current = q.poll();
            int c_v = current.node;

            if (visited[c_v]) continue; // 이미 방문한 적이 있는 노드는 다시 큐에 넣지 않용
            visited[c_v] = true;

            for (int i = 0; i < list[c_v].size(); i++) {
                Edge tmp = list[c_v].get(i);
                int next = tmp.node;
                int value = tmp.weight;

                if (distance[next] > distance[c_v] + value) { // 최소 거리로 업데이트하기
                    distance[next] = value + distance[c_v];
                    q.add(new Edge(next, distance[next]));
                }
            }
        }

        for (int i = 1; i <= V; i++) { //거리 배열 출력하기
            if (visited[i])
                System.out.println(distance[i]);
            else
                System.out.println("INF");
        }
    }
}

class Edge implements Comparable<Edge> {
    int node, weight;

    Edge(int v, int w) {
        this.node = node;
        this.weight = weight;
    }

    public int compareTo(Edge e) {
        if (this.weight > e.weight) return 1;
        else return -1;
    }
}
