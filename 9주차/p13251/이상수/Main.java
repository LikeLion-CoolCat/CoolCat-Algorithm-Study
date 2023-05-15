import java.util.ArrayList;
import java.util.Scanner;

public class p13251 { // 실패
 

    public static void main() {


        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();// 종류

        int[] stoneType = new int[m];

        for(int i = 0; i < m; i++) {
            stoneType[i] = sc.nextInt(); // 각 종류별 개수
        }

        int k = sc.nextInt(); // 돌 뽑는 개수
        float temp;
//    2
//    5 7
//    1
        ArrayList<Float> a = new ArrayList<Float>();
        int[] stone = new int[m];


        for (int j = 0; j < m; j++) {
            temp = (float)k / (float) stoneType[j];
            if(temp >= 1){
                temp = 1;
            }
            a.add(temp);
        }

        float result = 1;

        for (int i = 0; i < a.size(); i++){
            result *= a.get(i);
        }

        System.out.println(result);
    }
}
