package p1934;

import java.util.Scanner;

public class p1934 {
//    두 수의 곱은 최대공약수 x 최소공배수와 같다.
//    유클리드 호제법은 최소공배수를 구하는 알고리즘 이므로,
//    유클리드 호제법을 통해 최소공배수를 구하면 최대공약수를 알 수 있지 않을까?!
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        int tmp = 0;
        int getzero = -1;

        for(int i=0; i<t; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(a < b)
            {
                tmp = b;
                b = a;
                a = tmp;
            }

            //두 수의 곱을 저장해둠.
            tmp = a*b;

            while(true)
            {
                getzero = a%b;

                if(getzero == 0)
                {
                    System.out.println(tmp/b);
                    break;
                }
                a = b;
                b = getzero;
            }
        }
    }
}
