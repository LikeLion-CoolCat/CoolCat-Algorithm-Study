import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class p1149 {

    static ArrayList colorStorage = new ArrayList<String>();

    public static void main() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList[] a = new ArrayList[n];

        for(int i = 0; i < n; i++){
            //R G B
            a[i] = new ArrayList<Integer>();
            a[i].add(sc.nextInt());//R
            a[i].add(sc.nextInt());//G
            a[i].add(sc.nextInt());//B
        }

        ArrayList<String> check = new ArrayList<>();

        char temp;

        for(int i = 0; i < n; i++){
            colorStorage.add(checkColor(a[i]));
        }

    }

    public static String checkColor(ArrayList<Integer> a){
        int min = 0;
        int index = 0;
        if(a.get(0) < min){
            min = a.get(0);
            index = 0;
        }
        if(a.get(1) < min){
            min = a.get(1);
            index = 1;
        }
        if(a.get(2) < min){
            min = a.get(2);
            index = 2;
        }

        return "";

    }
}
