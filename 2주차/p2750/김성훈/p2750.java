package p2750;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p2750 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> array = new ArrayList<Integer>();

        for(int i=0; i<n; i++)
        {
            array.add(sc.nextInt());
        }

        System.out.println("array = " + array);

        int tmp = 0;

        //1차순회 -> 2차순회 -> ...
        //앞 뒤 두 대상을 비교하기 때문에 size()-1
        for(int i=array.size()-1; i>0; i--)
        {
            //이렇게 진행되는 이유
            // -> 버블 정렬은 한 회차가 진행될 때마다 **가장 큰 수가 맨 뒤에 깔리게 된다.**
            // 그래서 맨 뒤 까지 검사를 할 필요가 없어지기 때문에,
            // 시간복잡도(?)를 줄이기 위해서 회차가 진행될 때마다 비교 대상도 줄거들게 하기 위한 것이다.
            // -> 그냥 대충 for 루프 덜 돌게 만드는게 더 좋은 프로그램 구성이니까... 라고 생각하면 편함
            for(int j=0; j<i; j++)
            {
                if(array.get(j) > array.get(j+1))
                {
                    //앞의 항목이 뒤의 항목보다 크다면 서로 변경해주기.
                    //임시 저장공간인 tmp 사용.
                    tmp = array.get(j);
                    array.set(j, array.get(j+1));
                    array.set(j+1, tmp);

                    /*
                    엄청 자주쓰는 정렬.. 공식?
                    tmp = array[0];
                    array[0] = array[1];
                    array[1] = tmp;
                     */
                }
            }
        }
        System.out.println("array = " + array);
    }
}
