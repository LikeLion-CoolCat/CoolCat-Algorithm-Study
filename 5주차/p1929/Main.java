import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        if(M==1)
            M++;
        int[] prime = new int[N+1];

        for(int i = 2; i*i<= N; i++){
            if(prime[i] == 0){
                for(int j = i*i ; j<=N;  j += i) {
                    prime[j] = -1;
                }
            }
        }

        for(int i=M; i<=N; i++){
            if(prime[i] == 0)
                sb.append(i+"\n");
        }

        System.out.println(sb);

    }
}
