package p1722;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p1722 {

    public static void main(String[] args) {

        //순열 : n개의 원소 중에서 r 개를 선택하여 나열하는 방법의 수 (nPr) => n!/(n-r)!

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int K = sc.nextInt();

        long[] factorial = new long[N + 1];
        factorial[0] = 1;

        //1~N 팩토리얼 저장
        for(int i=1; i<=N; i++)
        {
            factorial[i] = factorial[i - 1] * i;
        }

        int CASE1;

        int[] CASE2 = new int[N];

        //그러니까, 예를들어 N이 3인 경우
        // {1, 2, 3} , {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}

        //CASE1 => M번째 순열 고르기
        if(K == 1)
        {
            CASE1 = sc.nextInt();

            List<Integer> numbers = new ArrayList<>();

            for(int i=1; i<=N; i++)
            {
                numbers.add(i);     //선택할 숫자들 목록
            }

            for(int i= N-1; i >= 0; i--)
            {
                int index = (int) ((CASE1-1) / factorial[i]);   //이번에 선택할 숫자가 몇 번째 위치에 있는가?
                System.out.print(numbers.get(index) + " ");
                numbers.remove(index);                          //선택 완료 후 제거
                CASE1 -= factorial[i] * index;                  //이전에 만든 순열 개수 빼기
            }
            System.out.println();
        }
        else if(K == 2)     //CASE2 => 순열 K가 몇 번째 순열에 해당하는지 출력하기
        {
            long ans = 1;

            List<Integer> numbers = new ArrayList<>();

            //1~N 까지의 리스트
            for(int i=1; i<=N; i++)
            {
                numbers.add(i);
            }

            //현재 숫자가 LinkedList에 몇 번째 인덱스에 위치하는지를 찾고 뽑아낸 뒤,
            //남은 (숫자의 개수)! 와 곱하며 더해나간다.
            for(int i=0; i<N; i++)
            {
                CASE2[i] = sc.nextInt();
                int index = numbers.indexOf(CASE2[i]);  //이번에 입력된 값을 제거
                numbers.remove(index);
                ans += factorial[N - i - 1] * index;    //제거하면서, 몇 개의 숫자를 건너 뛰었는지를 기반으로 계산
            }
            System.out.println(ans);        //총 몇번 순열을 건너 뛰어서 결과로 도착했는가?
        }
    }
}
