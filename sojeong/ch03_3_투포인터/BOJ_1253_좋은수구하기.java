package com.example.algorithm.sojeong.ch03_3_투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253_좋은수구하기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int count = 0;
        int i;
        int j;
        for(int k=0; k<N; k++) {
            i = 0;
            j = N-1;
            while(i<j) {
                if( i != k && j != k) {
                    if(A[i]+A[j] < A[k]) {
                        i++;
                    } else if (A[i]+A[j] > A[k]) {
                        j--;
                    } else { // A[i]+A[j] == A[k]
                        i++;
                        j--;
                        count++;
                        break;
                    }
                } else if (i == k) {
                    i++;
                } else  {
                    j--;
                }
            }
        }

        System.out.println(count);
        br.close();
    }
}