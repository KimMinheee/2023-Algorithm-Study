package ch07_1_정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1747_팰린드롬 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 어떤 수
       if(N == 1){ // 1은 소수 아니므로 따로 처리
           System.out.println(2);
           System.exit(0);
       }
       for(int i=N; ;i++){
           if(isPalindrome(i) && isPrime(i)){ // 소수, 팰린드롬 둘다 만족할 때 (순서 바뀌면 느려짐)
               System.out.println(i);
               System.exit(0);
           }
       }

    }
    public static boolean isPrime(int k){ // 소수 구하기
        for(int i=2; i<=Math.sqrt(k);i++){
            if(k %i ==0){
                return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome(int m){ // 팰린드롬 판별
        char temp[] = String.valueOf(m).toCharArray(); //Integer값 char배열로 변환
        int s =0;
        int e =temp.length-1;
        while(s<e){
            if(temp[s] != temp[e]) //시작 인덱스랑 끝 인덱스값이 다를 때 false
                return false;
            s++;
            e--;
        }
        return true; //반복문 다 돌면 true
    }
}