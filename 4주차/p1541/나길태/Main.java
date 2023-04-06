import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        String[] minus = exp.split("-");
        int answer = 0;
        for(int i=0; i<minus.length; i++){
            if(i==0){ answer += sumString(minus[i]);}
            else answer -= sumString(minus[i]);
        }
        System.out.println(answer);
    }
    static int sumString(String s){
        String[] num =  s.split("[+]");
        int sum = 0;
        for(int i=0; i<num.length; i++){
            sum += Integer.parseInt(num[i]);
        }
        return sum;
    }
}
