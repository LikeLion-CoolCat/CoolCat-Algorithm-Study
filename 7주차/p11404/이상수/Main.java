public class p11404 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] map = new int[n+1][n+1];

        for(int i =0; i<=n; i++){
            for(int j = 0; j<=n; j++){
                if(i == j)
                    map[i][j] = 0;
                else
                    map[i][j] = 100_000*n;
            }
        }

        for(int i = 0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[a][b] = Math.min(map[a][b], c);
        }
        // 거쳐가는 지점
        for(int i = 1; i<=n; i++)
            //시작지점
            for(int j = 1; j<=n; j++)
                //도착지점
                for(int k = 1; k<=n; k++)
                    map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++) {
                if(map[i][j] == 100_000*n)
                    System.out.print(0+" ");
                else
                    System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
