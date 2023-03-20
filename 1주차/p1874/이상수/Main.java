import java.util.Scanner;
import java.util.Stack;


public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();

        int n = sc.nextInt();
        int number = 0;
        int count = 1;
        for(int i = 0; i < n; i++) { // 해결 못했습니다...
            number = sc.nextInt();
            while (true) {
                if(stack.isEmpty()) {
                    stack.push(count);
                    count++;
                }
                if(stack.peek() == number){
                    //System.out.println("+");
                }else if(stack.peek() > number){
                    System.out.println("-");
                    stack.pop();
                    count--;
                }else if(stack.peek() < number){
                    System.out.println("+");
                    stack.push(count);
                    count++;
                }

                if(count == number){
                    break;
                }
            }

        }
    }
}
