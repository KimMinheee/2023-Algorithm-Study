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
                stack.push(j); //1부터 들어온 값이 나올때까지 push
                sb.append("+\n");
            }
            if(stack.peek()==A){
                stack.pop(); //해당 숫자가 나왔다면 그 숫자를 pop
                sb.append("-\n");
            }
            else{
                yesNo=true; //안되는 경우의 수 있으면 플래그 세워둠
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
/*
풀이 
처음 나온 숫자까지 push 그숫자가 나왔으면 pop 그다음 숫자까지 큰지 작은지 판다내서 push pop 숫자가 작아서 pop가 필요하면
pop하면서 숫자꺼내줌 찾으면 그것도 팝 
*/
