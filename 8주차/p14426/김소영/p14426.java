import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://yeoncoding.tistory.com/441 참고

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] s = new String[n];

        for(int i=0; i<n; i++) s[i] = br.readLine();

        int answer=0;
        while(m-- >0){
            String str= br.readLine();
            for(int i=0; i<n; i++){
                if(str.equals(s[i].substring(0, str.length()))){
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
