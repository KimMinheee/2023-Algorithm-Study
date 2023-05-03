package sojeong.ch03_5_스택과큐;

import java.util.*;

public class BOJ_1874_스택수열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 총 수열 개수

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int start = 0; //0부터 오름차순으로 스택에 푸시하기 위해서(실제로 0은 안들어감)

        while (n > 0) {
            int value = sc.nextInt(); //수열 값
            if (value > start) {
                for (int i = start + 1; i <= value; i++) {
                    stack.push(i); // start+1부터 입력받은 값까지 스택에 푸시
                    sb.append("+").append('\n');
                }
                start = value; // value 위의 숫자로 푸시하기 위함(EX-4까지 돌았으면 그 다음부턴 5부터 채워져야함)
            } else if (stack.peek() != value) { // start가 value보다 큰데 스택의 top에 있는 원소가 value와 같지 않다면
                //맨 위 스택에 있는 값이랑 예제 입력값이랑 다를 때는 POP불가
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append('-').append('\n');
            n--;
        }
        System.out.println(sb);
    }
}