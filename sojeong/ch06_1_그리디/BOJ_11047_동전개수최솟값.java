package ch06_1_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11047_동전개수최솟값 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 동전 종류 개수
        int K = Integer.parseInt(st.nextToken()); // 동전 가격의 합

        int[] arr = new int [N]; // 동전 종류 개수 만큼 담을 배열

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        //greedy -> 최대한 큰 동전 부터 먼저 사용 하기
        int count = 0;
        for(int i=N-1; i>=0; i--) { // 뒤에서부터(오름차순 일 때) 탐색
            if (arr[i] <= K) { //현재 동전 단위가 K보다 작거나 같아야 조합 가능
                count += (K / arr[i]); // (몫)현재 단위로 구성할 수 있는 개수 더해줌

                K = K % arr[i]; // (나머지)사용 하고 남은 값으로 K초기화
            }
        }
        System.out.println(count);

    }
}
