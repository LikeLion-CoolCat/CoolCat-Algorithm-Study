package p1541;

import java.util.Scanner;

public class p1541 {

    //세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다.
    //그리고 나서 세준이는 괄호를 모두 지웠다.
    //그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
    //괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.

    //첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고,
    // 가장 처음과 마지막 문자는 숫자이다. 그리고 연속해서 두 개 이상의 연산자가 나타나지 않고,
    // 5자리보다 많이 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다.
    // 입력으로 주어지는 식의 길이는 50보다 작거나 같다.

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String expression = sc.nextLine();

        System.out.println("expression = " + expression);

        //**연산의 순서는 바뀌지 않은 채** 괄호만 쳐서 최소값이 되도록 한다?
        //-와 - 사이에서 더해지는 값들을 모두 괄호로 쳐서 뺄셈이 되도록 한다...?
        //맨 앞, 뒤에는 무조건 숫자라는 조건이 있기 때문에 고려할 필요가 없음.
        //ex) 20 - 30 + 40 - 50 + 80
        // -> 20 -(30 + 40) - (50 + 80) = -180

        String[] arr = expression.split("-");

        int result = 0;

        int plus_result = 0;

        //문제점 -> +만 주어진 식일 경우에는?
        //-> 처음부터 +로 나누기...?
        //arr.length == 1인 경우는 더하는 식만 있을 경우밖에 없다.
        if(arr.length == 1)
        {
            arr = expression.split("\\+");

            for(int i=0; i<arr.length; i++)
            {
                result += Integer.parseInt(arr[i]);
            }

            System.out.println("result = " + result);
            return;
        }

        //위에서 걸러지지 않으면 의도하던 첫 숫자에 모든걸 빼는 식임.
        result = Integer.parseInt(arr[0]);

        for(int i=1; i<arr.length; i++)
        {
            //-로 분할했을 때 단순 수가 아닌 +가 함께있는 식이 주어진다면
            //변환이 불가능하기 때문에, +기준으로 잘라준 후 더한 값을 다시 대입해준다.
            if(arr[i].contains("+"))
            {
                String[] plus_arr = arr[i].split("\\+");
                for(int j=0; j<plus_arr.length; j++)
                {
                    plus_result += Integer.parseInt(plus_arr[j]);
                }
                arr[i] = String.valueOf(plus_result);
            }
            result -= Integer.parseInt(arr[i]);
            plus_result = 0;
        }

        System.out.println("result = " + result);
    }
}
