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
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int i;
        boolean arr[] = new boolean[N + 1];
        arr[0] = arr[1] = true; // 0과 1은 소수에서 제외.

        // 에라토스테네스의 체 사용
        int sqrt = (int) Math.sqrt(N);
        for (i = 2; i <= sqrt; i++) {

            for (int j = 2; j <= N / i; j++) {
                if (arr[i * j] == true) {
                    continue;
                } else {
                    arr[i * j] = true;
                }
            }
        }

        for (i = M; i <= N; i++) {
            if (arr[i] == false) {
                System.out.println(i);
            }
        }
    }
}
