package minhee.자료구조.구간합;

import java.io.*;
import java.util.StringTokenizer;

public class Boj11659_구간합구하기4 {
    static int N,M; //수의 개수, 합을 구해야 하는 횟수
    static int[] prefixSum;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        prefixSum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            prefixSum[i] = prefixSum[i-1] +Integer.parseInt(st.nextToken());
        }

        for(int tc=0; tc<M; tc++){ //M번 만큼 합 구함
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            long answer = 0;
            answer = prefixSum[end] - prefixSum[start-1];
            sb.append(answer+"\n");
        }

        System.out.print(sb.toString());
        br.close();

    }
}
