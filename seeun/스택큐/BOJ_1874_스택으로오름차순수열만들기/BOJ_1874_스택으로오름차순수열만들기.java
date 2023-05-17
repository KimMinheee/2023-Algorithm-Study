package week2;

import java.io.*;
import java.util.Stack;

public class BOJ_1874_스택으로오름차순수열만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //마지막 출력 위한 BufferedWriter 생성
        StringBuilder sb = new StringBuilder(); //결과 문자열 저장 위한 StringBuilder 생성
        Stack<Integer> st = new Stack<>();
        int n  = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int turn = 0; //수열 담긴 배열요소 턴
        int num = 1; //푸시할 자연수
        while(turn < n) { //배열요소 순회

            //배열요소가 자연수 이상일 때까지 자연수 push
            while (arr[turn] >= num) {
                st.push(num++);
                sb.append("+\n");
            }
            st.pop(); //top에 있는 자연수 num은 배열요소와 같으므로 pop
            sb.append("-\n");
            turn++; //다음 배열 요소로 넘어가기

            //배열 요소가 자연수 미만일 때까지 pop, 자연수가 클 경우 계속 출력
            while (!st.isEmpty() && arr[turn] < num) {
                int val = st.pop();
                sb.append("-\n");
                if (val != arr[turn++]) {
                    sb = new StringBuilder();
                    sb.append("NO");
                    bw.write(sb.toString());
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
