import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean yesNo = false;
        int j=1;
        int num = Integer.parseInt(br.readLine());

        for(int i=0; i<num; i++){
            int A = Integer.parseInt(br.readLine());
            for(; j <= A; j++){
                stack.push(j);
                sb.append("+").append("\n");
            }
            if(stack.peek()==A){
                stack.pop();
                sb.append("-").append("\n");
            }
            else{
                yesNo=true;
            }
        }
        if(yesNo==true){
            System.out.println("NO");
        }
        else{
            System.out.println(sb);
        }
        br.close();
    }
}
