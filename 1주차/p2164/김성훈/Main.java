package p2164;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p2164 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        //카드 수
        int card_list = sc.nextInt();

        //큐 카드 리스트
        Queue<Integer> queue = new LinkedList<>();

        //제일 위에 있는 카드를 삭제하고, 새로 추가함(아래로 옮김)
        int top_card = -1;
        
        for(int i=1; i<=card_list; i++)
        {
            queue.add(i);
        }

        //카드가 한장만 남을 때까지 반복.
        while(queue.size() > 1)
        {
            //우선 제일 위에 있는 카드를버린다.
            queue.remove();

            //제일 위에 있는 카드를 아래에 있는 카드 밑으로 옮긴다. (삭제 -> 새로 추가)
            top_card = queue.remove();
            queue.add(top_card);
        }

        System.out.println("queue.poll() = " + queue.poll());
        
    }
}
