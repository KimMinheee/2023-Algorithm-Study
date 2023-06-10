import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] subtraction = br.readLine().split("-");

        int result = sum(subtraction[0]);

        for(int i = 1; i < subtraction.length; i++) {
            result -= sum(subtraction[i]);
        }

        System.out.println(result);
    }

    public static int sum(String s) {
        String[] addition = s.split("\\+");
        int result = 0;

        for(String num : addition) {
            result += Integer.parseInt(num);
        }

        return result;
    }
}
