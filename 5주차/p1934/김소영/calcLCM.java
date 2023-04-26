import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        long[] answer = new long[test];
        for(int i=0;i<test;i++){
            long max = sc.nextInt();
            long min = sc.nextInt();
            long res = gcd(max, min);
            answer[i] = res*(max/res*min/res);
        }
        for(long a : answer)
            System.out.println(a);
    }

    public static long gcd(long max, long min){
        while(true){
            long div = max%min;
            if(div == 0) return min;
            else{
                max = min;
                min = div;
            }
        }
    }
}
