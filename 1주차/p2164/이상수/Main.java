import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{// [BOJ] 2164번 문제 정답처리된 코드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            queue.add(i+1);
        }

        for(int i = 0; i < n-1; i++) {
            queue.remove();
            queue.add(queue.poll());
        }
        System.out.println(queue.peek());
    }
}



//public class Main { // [BOJ] 2164번 문제
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        int length = 0;
//        int[] a = new int[n];
//        int temp = 0;
//
//        for(int i = 0; i < a.length; i++){ // 값 초기화
//            a[i] = i+1;
//        }
//
//        length = a.length - 1;
//
//        while(length > 1){//index가 0이 될때까지
//            temp = a[1];
//            for(int i = 0; i < length-1; i++){
//                a[i] = a[i+2];
//            }
//            length--;
//            a[length] = temp;
//        }
//        System.out.println(temp);
//    }
//}
////시간초과 코드
