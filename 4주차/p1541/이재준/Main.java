import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
public class Main {	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] strArr = new String[50];
		String str = br.readLine();
		st = new StringTokenizer(str, "-");
		int result = 0;
		int n =0;
		int sum =0;
		int p =0;
		while(st.hasMoreTokens()) {
			String s = st.nextToken();
//			System.out.println(s);
			while(true) {
				if(s.charAt(p)!=0) {
					break;
				} else {
					s.replace("0", "");
					System.out.println(s);
				}
			}
			if(s.length()>0)
				strArr[n++] = s;
		}
		st = new StringTokenizer(strArr[0], "+");
		while(st.hasMoreTokens()) {
			sum += Integer.parseInt(st.nextToken());
		}
		result = sum;
		for(int i=1; i<n; i++) {
			sum = 0;
			st = new StringTokenizer(strArr[i],"+");
			while(st.hasMoreTokens()) {
				sum += Integer.parseInt(st.nextToken());
			}
			result -= sum;
		}
		System.out.println(result);
		
	}
}
