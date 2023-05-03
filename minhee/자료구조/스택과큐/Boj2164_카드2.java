package minhee.자료구조.스택과큐;

import java.io.*;
import java.util.*;
public class Boj2164_카드2 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deq = new LinkedList<>();

        for(int i=1; i<=N; i++){
            deq.addLast(i);
        }

        while(!deq.isEmpty()){
            //1. 제일 위 버림
            int num = deq.removeFirst();

            //마지막 수 였다면 출력 후 while문 나가기
            if(deq.isEmpty()){
                bw.write(String.valueOf(num));
                break;
            }

            //2. 그 다음 값 제일 아래로 옮김
            int tmp = deq.removeFirst();
            deq.addLast(tmp);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
