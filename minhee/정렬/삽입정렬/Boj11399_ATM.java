package minhee.정렬.삽입정렬;

import java.io.*;
import java.util.*;

public class Boj11399_ATM {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(data);

        //구간 합 구하기
        for(int i=1; i<N; i++){
            data[i] = data[i]+data[i-1];
        }

        System.out.println(Arrays.stream(data).sum());

        br.close();
    }
}
