public class p2293 {

    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] num = new int[n+1];
        int[] dpmemo = new int[k+1];
        dpmemo[0] = 1;

        for(int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(br.readLine());
            for(int j=num[i]; j<=k; j++){
                dpmemo[j] += dpmemo[j-num[i]];
            }
        }
            System.out.println(dpmemo[k]);
    }
}
