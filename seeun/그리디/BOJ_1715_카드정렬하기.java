package week4;

import java.io.*;
import java.util.PriorityQueue;

public class BOJ_1715_카드정렬하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int rslt = 0;
        while (pq.size()>1) {
            int cnt = pq.poll() + pq.poll(); // 매번 최솟값끼리 더해야함
            pq.add(cnt); //2개 묶인 결과 다시 넣기
            rslt += cnt; //지금까지 비교 횟수
        }

        bw.write(rslt + "\n");
        br.close();
        bw.close();
    }
}
