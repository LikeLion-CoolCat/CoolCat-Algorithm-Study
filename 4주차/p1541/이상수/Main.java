import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) { // [BOJ] 1541 미완성
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(s);

        ArrayList<Integer> a = new ArrayList<>();

        int[] checkOperIndex = new int[s.length()-1]; // + : 1 | - : 2

        int checkOperCount = 0;
        //마이너스
        int prevIndex = 0;

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+'){
                a.add(Integer.parseInt(s.substring(checkOperIndex[prevIndex++], i-1)));
                checkOperIndex[checkOperCount++] = i;
            }
            else if(s.charAt(i) == '-'){
                a.add(Integer.parseInt(s.substring(checkOperIndex[prevIndex++], i-1)));
                checkOperIndex[checkOperCount++] = i;
            }

        }
        
    }
}
