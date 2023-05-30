package ch07_3_유클리드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_21568_AxByC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); // 1번째수
        int b = Integer.parseInt(st.nextToken()); // 2번째수
        int c = Integer.parseInt(st.nextToken()); // 3번째수

        long gcd = gcd(a, b);
        if (c % gcd != 0) { // c가 최대 공약수의 배수가 아니면 -1 출력
            System.out.println(-1);
        } else {
            int mok = (int) (c / gcd); // 나머지(b)가 0이 될때까지 재귀 함수를 호출하는 유클리드 호제법 함수 호출
            long[] ret = Excute(a, b);
            //결괏값에 c/최대 공약수의 값을 곱한 후 해당 값 출력
            System.out.println(ret[0] * mok + " " + ret[1] * mok);
        }
    }
    // 유클리드 호제법 함수 구현
    private static long[] Excute(long a, long b) {
        long[]ret = new long[2];
        if(b==0){
            ret[0] =1; ret[1]=0; // x=1, y=0 설정하고 return
            return ret;
        }
        long q = a/b;
        long [] v = Excute(b, a%b); // 재귀형태로 유클리드 호제법 수행
        ret[0] = v[1]; //역순으로 올라오면서 x,y값 계산
        ret[1] = v[0]-v[1]*q; // 몫 계산
        return ret;
    }

    private static long gcd(long a, long b) { //최대 공약수 gcd()함수 구현
        while(b != 0){
            long temp = a % b;
            a = b;
            b = temp;
        }
        return Math.abs(a);
    }
}