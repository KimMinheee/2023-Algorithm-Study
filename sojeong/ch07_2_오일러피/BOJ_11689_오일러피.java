package ch07_2_오일러피;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11689_오일러피 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine()); 
        long pi = n;
        for (long i = 2; i<=Math.sqrt(n); i++) { // 제곱근까지만 진행
            if (n % i == 0) { // i가 소인수인지 확인
                pi = pi - pi / i; //결괏값 업데이트
            }
            while (n % i == 0) { // 2^7*11 일 때 2^7없애고 11만 남김
                n /= i;
            }

        }
        while (n > 1) { // 아직 소인수 구성이 남아 있을 때
            pi = pi -pi / n;
        }
        System.out.println(pi);
    }
}

