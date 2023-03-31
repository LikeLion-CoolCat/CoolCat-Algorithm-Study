public class Main {


	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);



		int m = Integer.parseInt(br.readLine());
		int[] arr2 = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}

		for(int i =0; i<arr2.length ; i++ ) {
			int tmp = 0;
//			if(pl>=pr)
//				System.out.println(0);

			int pl = 0;
			int pr = n-1;

			while(pl<=pr) {
				int pc = (pl+pr)/2;
				if(arr2[i] == arr[pc]) {
					tmp =1;
					break;
				}
				else if(arr2[i]<arr[pc]) {
					pr = pc-1;
				}
				else if(arr2[i]>arr[pc]) {
					pl = pc+1;
				}
				
			}
			System.out.println(tmp);
		}
	}
}
