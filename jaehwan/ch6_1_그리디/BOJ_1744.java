import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1744 { //수 묶기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());//양수 우선순위 큐 내림차순
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();//음수 우선순위 큐 큰 숫자부터 앞으로 온다
        int one = 0;//1의 개수
        int zero = 0;//0 개수
        for (int i = 0; i < N; i++) { // 4가지 그룹으로 나눈다
            int data = sc.nextInt();//숫자를 입력 받으면 4개로 바꿈
            if (data > 1) { //1보다 큰 경우
                plusPq.add(data); //양수 우선순위 큐로 집어넣는다
            } else if (data == 1) { //1일경우
                one++;
            } else if (data == 0) {//0일 경우
                zero++;
            } else {
                minusPq.add(data);//음수일 경우
            }
        }
        int sum = 0;// 최종 결과값
        while (plusPq.size() > 1) {//안에 값이 있을 경우
            int first = plusPq.remove();
            int second = plusPq.remove();
            sum = sum + first * second;
        }
        if (!plusPq.isEmpty()) { //안에 값이 1일 경우 일로옴 검사 0이면 넘김
            sum = sum + plusPq.remove();
        }
        while (minusPq.size() > 1) {
            int first = minusPq.remove();
            int second = minusPq.remove();
            sum = sum + first * second;
        }
        if (!minusPq.isEmpty()) { //음수 짬 처리
            if (zero == 0) { //0이 한개도 없을 경우엔 마이너스를 그대로 더해주고 아무것도 안해주면 그대로 사라지는 것이다.
                sum = sum + minusPq.remove();
            }
        }
        sum = sum + one;// 1은 그냥 더해줌
        System.out.println(sum);
    }
}
/*
숫자를 분류하는 아이디어가 필요하고 우선순위큐에서 양수를 내림차순,음수를 오름차순으로 받음 1개가 남을떄까지 처리한후에 나머지 짬처리
*/
