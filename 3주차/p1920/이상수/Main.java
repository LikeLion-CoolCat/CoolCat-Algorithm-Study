import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] a = new long[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int left;
		int right;
		int center;
		
		long key = 0;
		int isTrue = 0;
		
		for(int i = 0; i < m; i++) {
			key = Integer.parseInt(st.nextToken());
			left = 0;
			right = a.length - 1;
			center = right / 2;
			isTrue = 0;
			while(left <= right) {
				if(a[center] == key) {
					System.out.println("1");
					isTrue = 1;
					break;
				}
//				else if(center == 0) {
//					System.out.println("0");
//					break;
//				}
				else if(a[center] > key) {
					right = center - 1;
					center = (left + right) / 2;
				}
				else if(a[center] <key) {
					left = center + 1;
					center = (left + right) / 2;
				}
				
			}
			if(isTrue == 0) {
				System.out.println("0");
			}
			
		}
	}
}
