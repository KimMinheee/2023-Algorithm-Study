package week2;

import java.io.*;
import java.util.PriorityQueue;

public class BOJ_11286_절댓값힙 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> Math.abs(n1)==Math.abs(n2) ? (n1>n2 ? 1 : -1) : Math.abs(n1)-Math.abs(n2));
        //절댓값이 같은 경우 -> 작은수를 먼저 인큐할 수 있도록 단순 비교
        //절댓값이 다른 경우 -> 절댓값이 작은수를 먼저 인큐할 수 있도록 절댓값 비교

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            switch (x) {
                case 0: //x가 0인 경우 절댓값이 가장 작은 수 출력 및 제거
                    if(pq.isEmpty()){
                        sb.append(0 + "\n");
                    }
                    else{
                        sb.append(pq.poll() + "\n");
                    }
                    break;

                default: //x가 0이 아닌 경우 큐에 x 추가
                    pq.add(x);
                    break;

            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
