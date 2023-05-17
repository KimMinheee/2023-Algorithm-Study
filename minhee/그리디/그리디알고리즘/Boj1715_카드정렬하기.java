package minhee.그리디.그리디알고리즘;

import java.io.*;
import java.util.*;

public class Boj1715_카드정렬하기 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(); //최소

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            pq.add(num);
        }

        while(!pq.isEmpty()){
            int a = pq.poll();

            if(!pq.isEmpty()){
                int b = pq.poll();
                answer += (a+b);
                pq.add((a+b));
            }
            else{
                bw.write(String.valueOf(answer));
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
