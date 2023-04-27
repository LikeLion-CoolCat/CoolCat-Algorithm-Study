package p11404;

import java.util.Arrays;
import java.util.Scanner;

public class p11404 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();       //도시의 개수
        int m = sc.nextInt();       //버스의 개수

        //입력값이 일단은 10만 이하라고 했으니까 임시로 이렇게라도...!
        int MAX_VALUE = (Integer.MAX_VALUE/2);

        //도시에서 도시로 버스를 타고 이동하는데, 각 버스는 한 번 사용할 때마다 필요한 비용이 있다.
        //모든 도시의 쌍(a,b)에 대해서 도시a 에서 b 로 가는데 필요한 비용의 최솟값을 구하는 프로그램을 작성.

        int[][] graph = new int[n+1][n+1];

        for(int i=1; i<n+1; i++)
        {
            //Arrays.fill(graph[i], Integer.MAX_VALUE);
            Arrays.fill(graph[i], MAX_VALUE);   //모든 경로를 최대비용으로 설정(최소 비용 발견시 갱신)
            graph[i][i] = 0;                            //자신에서 자신으로 가는 경우는 없다. -> 0으로 출력
        }

        //*단일* 경로들의 비용을 입력받음. ( 우리가 해야할 것 -> *복합* 경로까지 고려한 최소 비용 정리 )
        for(int i=0; i<m; i++)
        {
            //[ 출발 도시, 도착 도시 ] => "가는데 필요한 버스 비용"
            int fromCity = sc.nextInt();
            int toCity = sc.nextInt();
            int cost = sc.nextInt();

            graph[fromCity][toCity] = Math.min(graph[fromCity][toCity], cost);
        }

        for(int k=1; k<n+1; k++)
        {
            for(int i=1; i<n+1; i++)
            {
                for(int j=1; j<n+1; j++)
                {

                    //Integer.MAX_VALUE 를 사용했을때의 문제점
                    //-> Integer 최대값에 무언가를 더할 경우에 -로 넘어가고, 최소값이 되어버림. (오버플로우)

                    //복합경로가 더 빠른 경우가 있는가? => 갱신
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for(int i=1; i<n+1; i++)
        {
            for(int j=1; j<n+1; j++)
            {
                if(graph[i][j] <= MAX_VALUE)
                {
                    System.out.printf("%d ", graph[i][j]);
                }
                else
                {
                    System.out.print("0 ");
                }
            }
            System.out.print("\n");
        }
    }
}
