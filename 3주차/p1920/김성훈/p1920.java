package p1920;

import java.util.Scanner;

public class p1920 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] n_list = new int[n];

        for(int i=0; i<n; i++)
        {
            n_list[i] = sc.nextInt();
        }

        int tmp = 0;

        //n_list 정렬
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n-1; j++)
            {
                if(n_list[j] > n_list[j+1])
                {
                    tmp = n_list[j];
                    n_list[j] = n_list[j+1];
                    n_list[j+1] = tmp;
                }
            }
        }

        int m = sc.nextInt();

        int[] m_list = new int[m];

        //요소 한개 들어갈 때마다 이분탐색
        for(int i=0; i<m; i++)
        {
            m_list[i] = sc.nextInt();

            if(binarySearch(n_list, m_list[i]))
            {
                System.out.println("1");
            }
            else
            {
                System.out.println("0");
            }
        }
    }

    //이분탐색
    public static boolean binarySearch(int []list, int target)
    {
        int start = 0;
        int middle;
        int end = list.length-1;

        //느낌은 약간.. middle pivot 으로 한 quick sort 랑 비슷한 느낌임 그건 파티션이라 좀 다르긴 하지만..?
        while(start <= end)
        {
            //중간 인덱스를 찾아서 중간보다 같은지, 큰지, 작은지를 비교 -> 시작부터 일단 반으로 확 줄음.
            middle = (start + end) / 2;

            //middle 값을 바꿔가면서 절반씩만 하면 되니까 빨라짐.
            //크면 오른쪽만 보면 되고, 작으면 왼쪽만 보면 되고 (여기에 middle 로 절반 비교까지)
            if(list[middle] == target)
            {
                return true;
            }
            else if(list[middle] > target)
            {
                end = middle - 1;
            }
            else if(list[middle] < target)
            {
                start = middle + 1;
            }
        }

        //못찾은 경우 start 랑 end 값이 같아졌다 -> 값을 찾지 못했다. -> false 반환
        return false;
    }
}
