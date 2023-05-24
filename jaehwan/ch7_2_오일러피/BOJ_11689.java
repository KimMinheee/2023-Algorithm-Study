import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11689 { //오일러의 피 함수 구현하기 (1~N중 과 서로소인 자연수 개수)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine()); //현재 소인수 구성
        long pi = n; //서로소의 개수
        for(long i = 2; i <= Math.sqrt(n); i++) { //제곱근까지 진행
            if(n % i == 0) { // P가 소인수 일 경우에만 결과 값 바꿔줌
                pi = pi - pi / i;
            }
            while(n % i == 0) { //n을 i로 나눌 수 없을때까지 반복
                n /= i;
            }
        }
        if(n!=1) { //보통 마지막에 n이 1이 되는데 소인수가 누락된 케이스 
            pi = pi/n*(n-1); //반복문 종료후 현재 N이 1보다 크면 N이 마지막 소인수라는 뜻 => 마지막 업데이트
        }
        System.out.println(pi); //출력

    }
}
/*
서로소: 두 자연수 A,B에 대하여 서로의 최대공약수가 1이라면 두 자연수는 서로소이다.
코드는 간단하나 오일러 피 원리를 알고 있어야 풀 수 있는 문제이다.

결과값 = 결과값 - 결과값/현재값 

* */
