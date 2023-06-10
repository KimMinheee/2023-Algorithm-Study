package ch07_1_정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929_소수구하기 {
    public static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        primeNumber(m, n);
    }

    static void primeNumber(int m, int n) {
        int[] arr = new int[n+1];
        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= n; i++) {//배열 초기화
            arr[i] = i;
        }

        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) continue; //이미 지워진 수는 건너뛴다
            for (int j = i+i; j <= n; j += i) { //i=2부터 시작해서 i의 배수들을 배열에서 지워준다
                arr[j] = 0;
            }
        }
        for (int i = m; i <= n; i++) { // 0이 아닌값 즉, 소수가 아닌 값 출력
            if (arr[i] != 0)
                sb.append(i + "\n");
        }
        System.out.print(sb);
    }
}
