import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] mx = {-1, 1, 0, 0};
    static int[] my = {0, 0, -1, 1};
    static char[][] arr ; 
    static boolean[][] visit ;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int normal=0;
        int notNormal =0;

        N = Integer.parseInt(bf.readLine());
        arr = new char[N+1][N+1];
        visit = new boolean[N][N];


        for(int i=0; i<N; i++){
            String str = bf.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visit[i][j]){
                    dfs(i, j);
                    normal++;
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i][j] == 'G')
                    arr[i][j] = 'R';
            }
        }

        visit = new boolean[N][N];


        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visit[i][j]) {
                    dfs(i, j);
                    notNormal++;
                }
            }
        }

        System.out.println(normal + " " + notNormal);
    }

    //row = x  column = y
    public static void dfs(int r, int c){
        visit[r][c] = true;
        char color = arr[r][c];

        for(int i=0; i < 4; i++){
            int moveR = r + mx[i];
            int moveC = c + my[i];

            if(moveR <0 || moveC <0 || moveR >=N || moveC >=N) continue;
            else if(arr[moveR][moveC] == color && !visit[moveR][moveC]){
                dfs(moveR, moveC);
            }
        }
    }
}
