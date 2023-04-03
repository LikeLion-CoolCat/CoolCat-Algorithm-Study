import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("동전의 종류와 가격을 입력하세요. : ");
        int cnt=0;
        int size = sc.nextInt();
        int price = sc.nextInt();
        System.out.print("동전의 종류를 입력하세요. (최대 "+size+"개) : ");
        int[] arr = new int[size];
        
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
      
        Arrays.sort(arr); //무조건 당장 좋아보이는 방식으로 선택 > 정렬하여 큰 값부터 먼저 나눠본다
        for(int i=size-1;i>=0;i--){
            if(price/arr[i]>0){
                cnt += price/arr[i];
                price %= arr[i];
                if(price==0) break;
            }
        }
        if(price>0) System.out.println("주어진 동전만으로는 지불할 수 없습니다.");
        System.out.println("사용된 동전의 개수 : "+ cnt +" 개");
    }
}
