package minhee.자료구조.구간합;

import java.util.*;
import java.io.*;
public class Boj11660_구간합구하기5
{
    static int N,M; //표의 크기, 합을 구해야 하는 횟수
    static int[][] prefixSum; //구간합 저장하는 2차원 배열
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        prefixSum = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                int num = Integer.parseInt(st.nextToken());
                int prefix = 0;

                if(j-1 >= 1) prefix += prefixSum[i][j-1];
                if(i-1 >= 1) prefix += prefixSum[i-1][j];
                if(j-1>=1 && i-1>=1) prefix -= prefixSum[i-1][j-1];
                prefix += num;
                prefixSum[i][j] = prefix;

            }
        }

        for(int tc=0; tc<M; tc++){
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            bw.write(getPrefixSum(startX, startY, endX, endY)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
    static int getPrefixSum(int startX, int startY, int endX, int endY){
        return prefixSum[endX][endY]
                -(prefixSum[endX][startY-1] + prefixSum[startX-1][endY])
                +prefixSum[startX-1][startY-1];
    }

}