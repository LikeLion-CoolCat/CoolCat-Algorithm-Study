import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("수식을 입력하세요. : ");
        String formula = sc.nextLine();
        String[] tempForm;
        int sum = 0;
        if(!formula.contains("-")) {
            // -가 하나도 없는 경우, 그냥 계산하면 됨
            sum=sumcalc(formula);
        } else if (!formula.contains("\\+")) {
            // +가 하나도 없는 경우, 모든 수를 더해서 마이너스만 곱해주면 됨
            sum=sumcalc(formula.replaceAll("-","+"));
            sum*=-1;
        } else {
            //섞여있는 경우
        }

        System.out.println("결과 : "+sum);
    }

    public static int recalc(String formula){
        int sum=0;
        String[] tempForm = formula.split("\\+");
        for(String s : tempForm){
            if(!s.equals("")) sum+=Integer.parseInt(s);
        }
        return sum;
    }

    public static int sumcalc(String formula){
        int sum=0;
        String[] tempForm = formula.split("\\+");
        for(String s : tempForm){
            if(!s.equals("")) sum+=Integer.parseInt(s);
        }
        return sum;
    }
}
