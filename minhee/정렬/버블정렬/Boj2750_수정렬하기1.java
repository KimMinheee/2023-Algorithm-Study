package minhee.정렬.버블정렬;
/**
 * BOJ2750_수정렬하기1
 * -> 버블정렬로 품(N이 작아서 가능)
 */

import java.io.*;
public class Boj2750_수정렬하기1 {
    static int N;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        int[] data = new int[N];

        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(br.readLine());
        }

        bubbleSorting(data);

        for(int n : data){
            bw.write(n+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static void bubbleSorting(int[] data){
        for(int i=0; i<N-1; i++){
            for(int j=0; j<N-1-i; j++){
                if(data[j] > data[j+1]){
                    int tmp = data[j+1];
                    data[j+1] = data[j];
                    data[j] = tmp;
                }
            }
        }
    }
}
