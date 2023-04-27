import java.util.*;
import java.io.*;

//https://velog.io/@lifeisbeautiful/Java-%EB%B0%B1%EC%A4%80-4485%EB%B2%88-%EB%85%B9%EC%83%89-%EC%98%B7-%EC%9E%85%EC%9D%80-%EC%95%A0%EA%B0%80-%EC%A0%A4%EB%8B%A4%EC%A7%80-with-%EC%9E%90%EB%B0%94
//참고

public class Main {
	static int dirX[] = {0, 0, -1, 1};
	static int dirY[] = {-1, 1, 0, 0};
	static boolean visit[][];
	static int map[][];
	static int size[][];

	private static final int INF = Integer.MAX_VALUE / 4;
	static int N, nowX, nowY;

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int size;

		// (alt + shift + s) + o
		public Node(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}

		@Override
		public int compareTo(Node o) {
			return size - o.size;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder(); 
		int count = 1;

		String temp = "";
		while( !(temp = br.readLine()).isEmpty()  ) {
			N = Integer.parseInt(temp);
			if(N == 0) {
				break;
			}

			map = new int[N][N];
			visit = new boolean[N][N];
			size = new int[N][N];

			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
		
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());	
					size[i][j] = INF;
				}
			}

			BFS(0, 0, map[0][0]);
			sb.append("Problem " + count + ": " + size[N-1][N-1]).append('\n');
			count++;
		}

		System.out.println(sb);

	} 

	private static void BFS(int x, int y, int roopy) {
		PriorityQueue<Node> que = new PriorityQueue<>();
		visit[x][y] = true;
		que.offer(new Node(x, y, roopy));

		while( !que.isEmpty() ) {
	
			Node node = que.poll();

			for(int i=0; i<4; i++) {
				nowX = node.x + dirX[i];
				nowY = node.y + dirY[i];

				if( range_check() && !visit[nowX][nowY] && size[nowX][nowY] > (map[nowX][nowY] + node.size) ) {
					size[nowX][nowY] = map[nowX][nowY] + node.size;
					visit[nowX][nowY] = true;
					que.offer( new Node( nowX, nowY, size[nowX][nowY] ));
				}

			}
		}

	} 

	private static boolean range_check() {
		return (nowX >= 0 && nowY >= 0 && nowX < N && nowY < N);
	} 

} 
