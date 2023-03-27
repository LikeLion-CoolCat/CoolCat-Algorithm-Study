package 백준.Baekjoon11004;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(arr);
        System.out.println(arr[K-1]);
    }

    public static void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int s, int e) {
        if(s >= e) return;
        int m = pivot(arr, s, e);
        sort(arr, s, m-1);
        sort(arr, m, e);
    }

    private static int pivot(int[] arr, int s, int e) {
        int pivot = arr[(s + e) / 2];
        while(s <= e){
            while(arr[s] < pivot) s++;
            while(arr[e] > pivot) e--;
            if(s<=e){
                int tmp = arr[s];
                arr[s] = arr[e];
                arr[e] = tmp;
                s++;
                e--;
            }
        }
        return s;
    }

}
