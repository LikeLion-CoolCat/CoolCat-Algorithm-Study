package p14426;

import java.util.Scanner;

public class p14426_simple {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        String blank = sc.nextLine();

        String[] inputArr = new String[N];
        String[] toFindArr = new String[M];

        int[] count = new int[M];
        int counting = 0;

        for(int i=0; i<N; i++)
        {
            inputArr[i] = sc.nextLine();
        }

        for(int i=0; i<M; i++)
        {
            toFindArr[i] = sc.nextLine();
        }

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                if(count[j] == 0 && inputArr[i].contains(toFindArr[j]) && inputArr[i].startsWith(toFindArr[j]))
                {
                    if(count[j] == 0) {
                        count[j]++;
                        counting++;
                    }
                }
            }
        }

        System.out.println(counting);

    }
}
