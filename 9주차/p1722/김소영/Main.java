import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N  = Integer.parseInt(in.readLine()); 
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int num = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		boolean[] visited = new boolean[21];
		long[] f = new long[21];
		f[0] = 1;
		for(int i=1; i<21; i++) f[i] = f[i-1] * i; 
		if(num == 1) {
			long K = Long.parseLong(st.nextToken()); // N=4(1234~4321) 총24가지  K=12
			
			for(int i=0; i<N; i++) {
				for(int j=1; j<=N; j++) {
					if(visited[j]) continue;
					if(f[N-i-1] < K) K -= f[N-i-1];
					else {
						arr[i] = j; // 2 3 4 1
						visited[j] = true;
						break;
					}
				}
			}
			
			// Answer
			for(int i=0; i<N; i++) System.out.print(arr[i]+" ");
			
		} else {
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			} // 2 4 1 3
			
			/*
			 *   2 => 3! + (1)
			 *   4 => 2! + 2! + (2 3)
			 *   1 => 1!
			 *   3 => 0
			 */
			
			long ans = 1L;
			
			for(int i=0; i<N; i++) {
				for(int j=1; j<arr[i]; j++) {
					if(!visited[j]) {
						ans += f[N-i-1];
					}
				}
				visited[arr[i]] = true;
			}
			
			// Answer
			System.out.println(ans);
			
		}
		
	}
