package ch05_1_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2023_신기한소수찾기 {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        getResult(0,n);
        System.out.println(sb);
    }

    public static void getResult(int output, int n) {
        if (n == 0) {
            if (isPrime(output)) sb.append(output).append("\n");
            return;
        }
        for (int i=0; i<10; i++) {
            int next = output*10+i;
            if (isPrime(next)) getResult(next, n-1);
        }
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i=2; i<=Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

}
