package ch07_1_정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.plaf.synth.SynthTextAreaUI;

public class BOJ_1456_거의소수 {

    static long A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        long[] arr = new long[10000001];
        int count = 0;
        for (int i = 2; i <= Math.sqrt(arr.length); i++) {
            arr[i] = i;
        }
        primeNumber(arr);

        // 거의 소수 구하기
        for (int i = 2; i < 10000001; i++) {
            if (arr[i] != 0) { // 0이 아닐때 계산
                long temp = arr[i];
                while((double)arr[i] <= (double)B/(double)temp){ // MAX
                    if((double)arr[i] >= (double)A/(double)temp){ //MIN
                        count ++;
                    }
                    temp = temp*arr[i];
                }
            }
        }

        System.out.println(count);
    }

    public static void primeNumber(long[] arr) {
        for (int i = 2; i < 10000001; i++) {
            for (int j = 2 * i; j <= arr.length - 1; j = j + i) { // i배수를 탐색하기 위해서 j+i
                if (arr[j] == 0) { // 소수가 아니면
                    continue;
                }
                arr[j] = 0; //배수 다 지워주기
            }
        }
    }
}