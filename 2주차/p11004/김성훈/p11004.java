package p11004;

import java.util.Arrays;
import java.util.Scanner;

public class p11004 {

    public static void main(String[] args) {

        int n, k, pivot;

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();       //배열의 크기
        k = sc.nextInt();       //몇번째 수?

        int[] arr = new int[n];

        for(int i=0; i<n; i++)
        {
            arr[i] = sc.nextInt();
        }

        System.out.println("arr = " + Arrays.toString(arr));

        int left = 0;
        int right = n-1;

        System.out.println("left = " + left);
        System.out.println("right = " + right);

        quickSort(arr, left, right);

    }

    public static void quickSort(int[] arr, int left, int right)
    {
        int i=left;
        int j=right;

        //middle pivot Quick sort
        int pivot = arr[ (left+right) / 2 ];

        System.out.println("pivot = " + pivot);


        //중앙의 피벗 값을 기준으로, 비교하며 양쪽에서 조여감.
        while(i <= j)
        {
            while(arr[i] < pivot)
                i++;

            while(arr[j] > pivot)
                j--;

            //i에는 피벗(중앙)보다 크거나 같은 값이 남게 되고
            //j에는 피벗(중앙)보다 작거나 같은 값이 남게 된다.
            //이 둘을 교체한다.
            if(i <= j)
            {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;

                System.out.println("arr = " + Arrays.toString(arr));
            }

            //그룹을 나누고... 피벗보다 작은 그룹 / 피벗보다 큰 그룹을 나눠서 또 정렬...? (못함...)
        }
    }
}
