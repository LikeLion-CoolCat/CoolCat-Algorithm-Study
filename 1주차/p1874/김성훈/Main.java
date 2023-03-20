package p1874;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class p1874 {
    public static void main(String[] args) {

        //입력될 총 숫자의 수
        int num = -1;

        //입력되는 숫자들
        ArrayList<Integer> numbers = new ArrayList<>();

        //스택인덱스
        int st_index = 0;

        //스택
        Stack<Integer> stack = new Stack<>();

        //결과 리스트
        List<String> result = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        num = sc.nextInt();

        System.out.println("num = " + num);

        for(int i=0; i<num; i++)
        {
            numbers.add(i, sc.nextInt());
        }

        System.out.println("numbers = " + numbers);


        //스택에 1부터 n까지 숫자를 집어 넣는다.
        for(int j=1; j<=num; j++)
        {
            stack.push(j);
            result.add("+ push");

            //집어 넣는 도중에, 스택의 맨 위 항목과, 꺼내야할 숫자가 일치한다면? (기본적으로 스택은 비지 않는다는 조건 +)
            //한번만 진행하는 조건문이 아니라, 반복문이기 때문에 4, 3 순서로 뽑기를 한다면 둘 다 실행되고 for문으로 올라간다.
            while(stack.isEmpty() == false && stack.peek() == numbers.get(st_index))
            {
                //스택에서 팝
                stack.pop();
                result.add("- pop");

                //찾아야할 숫자를 다음으로 넘어간다.
                st_index++;
            }
        }

        if(stack.isEmpty() == false)
        {
            System.out.println("NO");
        }
        else
        {
            for(int i=0; i<result.size(); i++)
            {
                System.out.printf("result.get(%d) = %c \n", i, result.get(i));
            }
        }
        sc.close();
    }
}
