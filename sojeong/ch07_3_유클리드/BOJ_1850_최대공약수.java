package ch07_3_유클리드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1850_최대공약수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        for (long i = 0; i < gcd(Math.max(N, M), Math.min(N, M)); i++)
            sb.append("1");
        System.out.println(sb);
        br.close();
    }

    private static long gcd(long N, long M) {
        if (M != 0) {
            return gcd(M, N % M);
        } else {
            return N; // 계속 나누다가 0이 되면 return
        }
    }
}