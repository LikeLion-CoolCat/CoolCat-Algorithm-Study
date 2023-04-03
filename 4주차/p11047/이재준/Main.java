import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		for(int i=n-1; i>=0; i--) {
			arr[i] = Integer.parseInt(br.readLine());
		}
//		System.out.print(Arrays.toString(arr));
		int count = 0;
		for(int i=0; i<n; i++) {
			count += k/arr[i];
			k = k%arr[i];
			if(k==0)
				break;
		}
		System.out.println(count);
		
	}
}
