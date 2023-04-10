package p1929;

import java.util.ArrayList;
import java.util.Scanner;

public class p1929 {
    //소수 목록
    //static ArrayList<Integer> prime_list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //m 이상 n 이하의 소수를 모두 출력
        int m = sc.nextInt();
        int n = sc.nextInt();

        isPrime(m,n);
    }

    public static void isPrime(int m, int n) {

//        //소수 = 2보다 큰 자연수 중에서 1과 자기 자신을 제외한 자연수로는 나누어 떨어지지 않는 자연수.
//        //약수는 대칭의 형식을 띄기 때문에 제곱근 까지만 검사하면 된다.
//        for(; m<=n; m++)
//        {
//            boolean isPrime_bool = true;
//
//            for(int i=2; i<=Math.sqrt(m); i++)
//            {
//                if(m % i == 0)
//                    isPrime_bool = false;
//            }
//            if(isPrime_bool) {
//                System.out.println(m);
//            }
//        }

        //소수를 돌면서 찾는 방식이 아니라 소수가 아닌것을 지우는 방식 => 에라토스테네스의 체
        int[] prime_list = new int[n+1];

        for(int i=2; i<=n; i++){
            prime_list[i] = i;
        }

        //2~16
        //배수 지우기
        //아직 자세히는 이해가 잘 안됨. 공부 필요할듯
        for(int i=2; i<=Math.sqrt(n); i++)
        {
            if(prime_list[i] == 0)
                continue;

            for(int j=i*i; j<=n; j = j+i) {
                prime_list[j] = 0;
            }
        }

        for(int i=m; i<=n; i++)
        {
            if(prime_list[i] != 0)
                System.out.println(prime_list[i]);
        }
    }
}
