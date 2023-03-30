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

        int left = 0;
        int right = n-1;

        quickSort(arr, left, right);

        System.out.println(arr[k-1]);
    }

    public static int partition(int[] arr, int left, int right)
    {

        //middle pivot Quick sort
        int pivot = arr[ (left+right) / 2 ];

        //중앙의 피벗 값을 기준으로, 비교하며 양쪽에서 조여감.
        while(left <= right)
        {
            while(arr[left] < pivot)
                left++;

            while(arr[right] > pivot)
                right--;

            //i에는 피벗(중앙)보다 크거나 같은 값이 남게 되고
            //j에는 피벗(중앙)보다 작거나 같은 값이 남게 된다.
            //이 둘을 교체한다.
            if(left <= right)
            {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }
        }

        return left;
    }

    public static void quickSort(int[] arr, int left, int right)
    {
        if(left >= right)
        {
            return;
        }

        int partition_index = partition(arr, left, right);

        quickSort(arr, left, partition_index-1);
        quickSort(arr, partition_index, right);
    }
}
