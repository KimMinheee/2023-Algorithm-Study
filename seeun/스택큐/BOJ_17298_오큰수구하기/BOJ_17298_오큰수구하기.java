package week2;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17298_오큰수구하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); //수열 크기 N
        Stack<Pair> stack = new Stack<>(); //수열 넣기 위한 스택 생성
        StringTokenizer st = new StringTokenizer(br.readLine());

        int i=0; //인덱스
        Pair pair = new Pair(i++ ,Integer.parseInt(st.nextToken())); //첫번째 수 푸시
        int[] arr = new int[N]; //정답 배열
        stack.push(pair); //수열 첫번째 수 넣어주기
        
        while(st.hasMoreTokens()){
            pair = new Pair(i++ ,Integer.parseInt(st.nextToken())); //Pair 객체 생성

            while (!stack.isEmpty() && stack.peek().value < pair.value) { //스택 제일 위의 수보다 push하려는 수가 큰 동안
                Pair val = stack.pop();//pair보다 작은 수 val
                arr[val.idx] = pair.value;
            }
            stack.push(pair);
        }
        while(!stack.isEmpty()) { //남은 것들은 각 인덱스에 -1저장(오큰수를 찾지 못함)
            Pair p = stack.pop();
            arr[p.idx] = -1;
        }

        for(int k=0; k<N; k++){
            bw.write(arr[k] + " ");
        }
        bw.flush();
        bw.close();
    }
    
    //수열의 각 숫자의 인덱스와 값 저장하는 Pair 클래스
    private static class Pair {
        int idx;
        int value;

        public Pair(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }

}
