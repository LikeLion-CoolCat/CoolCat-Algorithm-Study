import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        boolean isMinus = false;
        int sum = 0;
        String numStr = "";

        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            if (isOperand(letter)) {
                numStr += letter;
            } else {
                if (isMinus) {
                    sum -= Integer.parseInt(numStr);
                } else {
                    sum += Integer.parseInt(numStr);
                }
                numStr = "";
                if (letter == '-') {
                    isMinus = true;
                }
            }
        }
        if (isMinus) {
            sum -= Integer.parseInt(numStr);
        } else {
            sum += Integer.parseInt(numStr);
        }
        System.out.println(sum);
    }

    private static boolean isOperand(char k) {
        return k != '+' && k != '-';
    }
}
