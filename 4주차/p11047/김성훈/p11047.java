package p11047;

import java.util.Scanner;

public class p11047 {

    static int n;
    static long k;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();       //동전의 종류 수
        k = sc.nextLong();     //최종 목푯값

        long[] coin_arr = new long[n];

        for(int i=0; i<n; i++)
        {
            coin_arr[i] = sc.nextLong();
        }

        greedy_algorithm(k, coin_arr);

    }

    static void greedy_algorithm(long k, long[] coin_arr)
    {
        //동전의 가치가 오름차순으로 입력이 주어지기 때문에 coin_arr 의 정렬은 필요 없음.

        int[] coin_count = new int[coin_arr.length];     //할당된 각 동전의 개수를 저장하는 배열

        long total = k;

        int result = 0;

        //가장 큰 동전부터 사용
        for(int i=coin_arr.length-1; i>=0; i--)
        {
            //동전이 쓰일 수 있으면(이번 동전이 총 액수보다 작거나 같으면)
            //쓸 수 있을 만큼 계속 털어씀(무한루프)
            while(total >= coin_arr[i])
            {
                total -= coin_arr[i];
                coin_count[i] ++;
                result++;
            }
        }

//        for(int i=0; i<coin_count.length; i++)
//        {
//            //result += coin_count[i];
//            System.out.printf("%d원 = %d개 \n", coin_arr[i], coin_count[i]);
//        }

        System.out.println("result = " + result);
    }
}
