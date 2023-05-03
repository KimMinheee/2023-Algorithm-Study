package sojeong.ch03_3_투포인터;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2018_연속된자연수의합구하기 {

    static int N;
    static int A[];

    void Solve() {
        int sum = 0, count = 0;
        // A[0] ~ A[N-1]까지 하나씩 진행
        for (int s = 0; s < N - 1; s++) {
            sum = A[s];
            // A[s] 다음 수부터 하나씩 더해나가다가 N과 같아지면 count++ 한다.
            for (int e = s + 1; e < N; e++) {
                if (sum == N) {
                    count++;
                    break;
                } else if (sum > N) {
                    break;
                }
                sum += A[e];
            }
        }
        System.out.println(count + 1); // 본인 숫자를 더함
    }

    void inputData() throws Exception {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = i + 1;
        }
    }

    public static void main(String[] args) throws Exception {
        BOJ_2018_연속된자연수의합구하기 m = new BOJ_2018_연속된자연수의합구하기();
        m.inputData(); // 입력 받는 부분
        m.Solve();// 여기서부터 작성
    }
}