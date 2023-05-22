package ch05_3_이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1300_배열에서K번째수찾기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long s = 1; // 시작 인덱스(1부터 시작)
        long e = K; // 종료 인덱스

        while (s < e) {
            long mid = (s + e) / 2;  // 임의의 mid를 중간 값으로 잡는다.
            long count = 0;

            /*
             *  임의의 x에 대해 i번 째 행을 나눔으로써 x보다 작거나 같은 원소의 개수 누적 합을 구하기
             *  이 때 각 행의 원소의 개수가 N(열 개수)를 초과하지 않는 선에서 합해주어야 한다.
             */
            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N); // 작은 수 카운트
            }

            // count가 많다는 것은 임의의 x(mid)보다 작은 수가 B[K]보다 많다는 뜻
            if (K <= count) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }

        System.out.println(s);
    }
}