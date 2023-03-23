import java.util.Scanner;
 
// 공부해서 꼭 풀어오겠습니다..... 주말까지 PR....


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int a[] = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        //구현부
        int left = 1;
        int right = n-1;
        int pivot = 0;
        int temp = 0;

        for(int i = 0; i < n; i++) {
            if (i > pivot) {
                
            }

        }

        for (int num: a) {
            System.out.println(num);
        }
    }
    void quick_sort(){

    }
}
