import java.util.Scanner;

public class BOJ_2343 { //블루레이
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();// 블루레이 개수
        int[] A = new int[N];
        int start = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {//레슨 수만큼
            A[i] = sc.nextInt(); // 레슨 입력 받아서
            if (start < A[i]) { //입력받을때마다 판별해서
                start = A[i]; // 시작값을 늘림
                end = end + A[i]; // 종료값은 누적
            }
        }
        while (start <= end) { // 예제 기준 기본 9 <=45
            int middle = (start + end) / 2; //27 이게 후보다
            int sum = 0;
            int count = 0; //현재 사용한 블루레이 개수
            for (int i = 0; i < N; i++) { //중앙의 값으로 모든 레슨 저장이 가능한지 확인
                if (sum + A[i] > middle) { //현재 블루레이에 저장할 수 없어 새로운 블루레이로 교체한다는 의미
                    count++;
                    sum = 0;
                }
                sum = sum + A[i];
            }
            if (sum != 0)//레슨의 길이가 블루레이의 크기를 초과한다면 블루레이 크기 증가시킴
                count++;
            if (count > M) //블루레이의 요구 개수보다 현재 블루레이가 많다면 
                start = middle + 1; //중앙값(후보)로 모든 레슨 저장이 불가능하면 중앙값을 +1
            else//
                end = middle - 1;//저장할 수 있다면 중앙값 -1 
        }
        System.out.println(start);
    }
}

/*
문제해설
블루레이의 크기가 모두 같고 녹화 순서가 바뀌지 않아야 한다에서 이진 탐색을 알아내야함
문제 이해가 어려웠으나 이진 탐색을 진행하면서 중간값이 블루레이 최소 크기의 후보가 된다는 걸 보고 이해했다.
*/
