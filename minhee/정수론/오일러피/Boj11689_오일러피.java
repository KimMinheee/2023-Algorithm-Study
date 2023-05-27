package minhee.정수론.오일러피;
/**
 * BOJ11689 - GCD(n,k) = 1
 * 자연수 N이 주어졌을때 1부터 N까지 수 중에서 N과 서로소인 개수를 구하기
 * (N과 K의 최대공약수가 1이다 == N과 K가 서로소이다)
 *
 * n의 크기가 최대 10^12 -> long으로 받야아 한다.
 */

import java.io.*;

public class Boj11689_오일러피 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());
        long result = n;

        for(int i=2; i<=Math.sqrt(n); i++){
            if(n % i == 0) result = result - result / i; //오일러곱
            while(n % i == 0){
                n /= i; //배수 지우기
            }
        }
        if(n > 1) //아직 값이 남아있을 때
            result = result - result / n;

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
