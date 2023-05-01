package minhee.자료구조.스택과큐;

import java.util.*;
import java.io.*;
public class Boj1874_스택수열 {
    static StringBuilder sb = new StringBuilder();
    static int[] data;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        data = new int[n];

        for(int i=0; i<n; i++){
            data[i] = Integer.parseInt(br.readLine());
        }

        int value = 0;
        for(int i=0; i<n; i++){
            int num = data[i];

            //stack에 넣기
            if(value <= num){
                while(value < num){
                    value++;
                    sb.append("+\n");
                    stack.push(value);
                }
            }

            //가장 상단(다음에 나올)값이 num과 같다면 꺼낸다.
            if(stack.peek() == num){
                sb.append("-\n");
                stack.pop();
            }
            else{
                System.out.println("NO");
                return;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();

    }

}
