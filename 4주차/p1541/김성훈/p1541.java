package p1541;

import java.util.Scanner;

public class p1541_re {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String expression = sc.nextLine();

        String[] arr = expression.split("-");

        int split_tmp = 0;
        int result = 0;

        //0번 인덱스에 대해 전 처리를 해둠.
        String[] first_split = arr[0].split("\\+");

        for(int j=0; j<first_split.length; j++)
        {
            result += Integer.parseInt(first_split[j]);
        }

        //더하기밖에 없는 경우
        if(arr.length == 1)
        {
            System.out.println(result);
            return;
        }

        for(int i=1; i<arr.length; i++)
        {
            //그 뒤에 있는 내용들은 다 더해서 초기값에 빼주면 됨.
            String[] other_split = arr[i].split("\\+");

            for(int j=0; j<other_split.length; j++)
            {
                split_tmp += Integer.parseInt(other_split[j]);
            }

            result -= split_tmp;
            split_tmp = 0;
        }

        System.out.println(result);
    }

}
