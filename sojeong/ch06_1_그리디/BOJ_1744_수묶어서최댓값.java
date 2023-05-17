package ch06_1_그리디;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1744_수묶어서최댓값 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 카드 묶음 개수

        // 내림차순으로 양수값 정렬
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        // 오름차순
        PriorityQueue<Integer> minusAndZero = new PriorityQueue<>();
        int one = 0;

        for(int i=1; i<=N; i++){
            int n = sc.nextInt();
            if(n > 1){ //양수값
                plus.add(n);
            }
            else if (n ==0 || n< 0){ //0이랑 음수
                minusAndZero.add(n);
            }
            else //1일때
                one++;
        }
        int sum = 0;

        //양수 묶기
        while(plus.size() > 1){
            int a = plus.poll();
            int b = plus.poll();
            sum += a*b;
        }
        if(!plus.isEmpty()){
            sum+= plus.remove(); //poll도 가능 rm이 아주 조금 더 빠름
        }

        while(minusAndZero.size() >1){
            int a = minusAndZero.poll();
            int b = minusAndZero.poll();
            sum += a*b;
        }
        if(!minusAndZero.isEmpty()){
            sum+= minusAndZero.remove();
        }
        sum+= one;
        System.out.println(sum);
    }
}