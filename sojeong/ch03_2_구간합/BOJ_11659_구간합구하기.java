package ch03_2_구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659_구간합구하기 {

    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        array = new int[n + 1];
        for (int i = 1; i <= n; i++) { // i까지의 누적합 구하기
            array[i] = array[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // a, b사이의 구간합은 array[b]-array[a-1]과 같다
            System.out.println(array[b] - array[a - 1]);
        }
    }
}
