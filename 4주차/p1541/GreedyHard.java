import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("수식을 입력하세요. : ");
        String formula = sc.nextLine();
        String[] tempForm;
        int sum = 0;
        sum=recalc(formula);
        System.out.println("결과 : "+sum);
    }

    public static int recalc(String formula){
        int sum=0;
        if(!formula.contains("-")){
            //+로만 이어진 수식
            return sumcalc(formula, true);
        } else if (!formula.contains("+")) {
            //-로만 이어진 수식
            return sumcalc(formula.replaceAll("-","+"), false);
        } else {
            //복합식
            String[] tempForm = formula.split("-",2);
            if(tempForm[0].equals("")){
                // -로 시작하는 식은 사실상 전부 음수 값을 리턴한다
                return sumcalc(formula.replaceAll("-","+"), false);
            }else {
                // 양수로 시작하는 식은 사실상 양수항의 합에서 가장 첫번째 -로 시작하는 식을 뺸 값을 더한 것과 같다
                return sumcalc(tempForm[0],true) + sumcalc(tempForm[1].replaceAll("-","+"), false);
            }
        }

    }

    public static int sumcalc(String formula, boolean positive){
        int sum=0;
        if(!formula.contains("+"))
            return Integer.parseInt(formula);
        String[] tempForm = formula.split("\\+");
        for(String s : tempForm){
            if(!s.equals("")) sum+=Integer.parseInt(s);
        }
        return (positive==true)? sum : sum*-1; // 양수 표기가 true면 양수의  합을 반환, 그게 아니면 음수의 합을 반환
    }
}
