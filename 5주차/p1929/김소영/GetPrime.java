import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = sc.nextInt();
        int max = sc.nextInt();
        boolean[] primeFlag = new boolean[max+1];
        calcPrime(primeFlag);
        for(int i=min;i<=max;i++){
            if(!primeFlag[i]) System.out.println(i);
        }
    }

    public static void calcPrime(boolean[] flag){
        flag[0] = true;
        flag[1] = true;
        for(int i=2;i<=Math.sqrt(flag.length);i++){
            if(flag[i]) continue;
            for(int j = i * i; j < flag.length; j += i) {
                flag[j] = true;
            }
        }
    }
}
