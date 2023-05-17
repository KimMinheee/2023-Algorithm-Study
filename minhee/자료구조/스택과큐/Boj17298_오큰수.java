package minhee.자료구조.스택과큐;
import java.util.*;
import java.io.*;

/**
 * 스택 이용한 풀이
 */

public class Boj17298_오큰수 {
    static int[] data; //원본 데이터
    static int[] answer; //정답 저장하는 배열
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        data = new int[n];
        answer = new int[n];
        Arrays.fill(answer,-1); //-1로 채움

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        getAnswer();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static void getAnswer()
    {
        Stack<Integer> stack = new Stack<>(); //인덱스 넣는 스택

        stack.push(0); //맨 처음 인덱스 push

        for(int i=1; i<n; i++){
            // stack에 값이 존재하고 스택 상단의 값보다 data[i]값이 크다면
            while(!stack.isEmpty() && data[stack.peek()] < data[i]){
                answer[stack.pop()] = data[i]; //정답배열에 데이터값
            }
            stack.push(i);
        }

        for(int i=0; i<n; i++){
            sb.append(answer[i]).append(" ");
        }
    }
}