package minhee.정수론.유클리드호제법;
/**
 * Boj1850 - 최대공약수
 * 자릿수 : 2^63 = 9,223,372,036,854,776,000
 */

import java.io.*;
import java.util.*;

public class Boj1850_최대공약수 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        //A를 더 작은 것으로 세팅
        if(A > B){
            long tmp = A;
            A = B;
            B = tmp;
        }

        long num = gcd(A, B);

        String str = "1";
        bw.write(str.repeat(Math.toIntExact(num))); //num번 만큼 반복
        bw.flush();
        bw.close();
        br.close();
    }
    static long gcd(long min, long max){
        long tmp = max % min;

        if(tmp == 0) return min;
        else return gcd(tmp, min);
    }
}
