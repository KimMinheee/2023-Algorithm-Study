package minhee.자료구조.배열과리스트;

import java.io.*;

/**
 * BOJ 11720 - 숫자의 합
 */
public class Boj11720_숫자의합 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String num = br.readLine();

        int answer = 0;
        for(int i=0; i<N; i++){
            answer += num.charAt(i)-'0';

        }

        System.out.println(answer);
        br.close();
    }
}
