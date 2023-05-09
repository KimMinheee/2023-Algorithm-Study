import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2164{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        int N = sc.nextInt();
        for(int i = 1; i <= N; i++) { //카드를 큐에 저장하기
            q.offer(i);
        }
        while(q.size() > 1) {   //카드가 1장 남을때까지
            q.poll();	          // 맨 앞의 카드 버림
            q.offer(q.poll());	// 맨앞꺼내고 그걸 동시에 맨 뒤에 삽입
        }
        System.out.println(q.poll());	// 마지막으로 남은 카드 출력
    }
}
//큐를 아는지 물어보는 문제 
