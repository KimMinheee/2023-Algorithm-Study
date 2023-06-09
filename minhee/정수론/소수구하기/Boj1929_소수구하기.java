package minhee.정수론.소수구하기;

/**
 * BOJ1929 - 소수구하기
 * : 에라토스테네스 체 사용
 */

import java.io.*;
import java.util.*;

public class Boj1929_소수구하기 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] nums = getPrimeNumber(M, N);

        if(M == 1) { //N==1일때는 아무것도 출력하지 않는다.
            if(N > 1){
                for(int i=2; i<=N; i++){
                    if(nums[i] == 0) bw.write(i+"\n");
                }
            }
        }
        else{
            for(int i=M; i<=N; i++){
                if(nums[i] == 0) bw.write(i+"\n");
            }
        }

        bw.flush();
        br.close();
        br.close();
    }
    static int[] getPrimeNumber(int start, int end){
        int[] nums = new int[end+1]; //N+1개 , 초기화 0

        //소수가 아닌 수들을 1로 변경
        for(int i=2; i<=end; i++){
            if(nums[i] == 0){ //소수
                int multiply = 2;
                while(i * multiply <= end){
                    nums[i * multiply] = 1;
                    multiply++;
                }
            }
            else continue;
        }

        return nums;

    }
}
