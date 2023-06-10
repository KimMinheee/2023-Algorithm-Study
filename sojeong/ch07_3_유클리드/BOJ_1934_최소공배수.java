package ch07_3_유클리드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1934_최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int ans = N*M/gcd(N,M);
            bw.write(Integer.toString(ans));
            bw.newLine();
        }
        bw.flush();
        bw.close();

    }
    private static int gcd(int N, int M) {
        if(M != 0){
            return gcd(M, N%M);
        }
        else{
            return N; // 계속 나누다가 0이 되면 return
        }
    }
}