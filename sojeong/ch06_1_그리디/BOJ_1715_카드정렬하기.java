package ch06_1_그리디;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1715_카드정렬하기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();// 카드 묶음 개수
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(sc.nextInt()); // 카드 묶음 큐에 저장
        }

        int count = 0; // 비교 횟수 카운트
        while (pq.size() > 1) { // 큐 사이즈가 1이 되면 종료하고 현재까지 비교 횟수의 합을 출력해야함
            int a = pq.poll();
            int b = pq.poll();

            count += a + b;
            pq.add(a + b); // 합한 카드 묶음 큐에 저장

        }
        System.out.println(count);
    }
}
