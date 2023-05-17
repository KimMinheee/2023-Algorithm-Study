import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1715 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int data1 = 0;
        int data2 = 0;
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //우선순위 자동 정렬 
        for (int i = 0; i < N; i++) {
            int data = sc.nextInt();
            pq.add(data);
        }
        while (pq.size() != 1) {
            data1 = pq.remove();//첫번째 값 제거
            data2 = pq.remove();//그다음도 제거
            sum += data1 + data2;
            pq.add(data1 + data2); // 합친거 다시 값에 집어넣음
        }
        System.out.println(sum);
    }
}
/*
* 우선 순위 큐를 쓰는 이유는 자동으로 정렬이 되기 때문에 루트 노드에 항상 우선순위의
* 값이 존재하게 됩니다. 이를 이용해서 쉽게 풀 수 있는 문제였습니다.
* */
