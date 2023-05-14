package minhee.탐색.이진탐색;
/**
 * BOJ2343 - 기타 레슨(블루레이)
 */

import java.util.*;
import java.io.*;

public class Boj2343_기타레슨{
    static int N,M; //강의개수, 블루레이 개수
    static int[] classes;
    static int answer = Integer.MIN_VALUE;
    static long[] prefixSum;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        classes = new int[N];
        prefixSum = new long[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            classes[i] = Integer.parseInt(st.nextToken());
        }

        //정렬
        Arrays.sort(classes);

        //누적합 구하기 [0, 1, 3, 6, 10, 15, 21, 28, 36, 45]
        prefixSum();
        System.out.println(Arrays.toString(prefixSum));


        //첫번째 그룹의 값이 그 다음 그룹보다 작을 동안 계속 한칸씩 플러스
        //맨 마지막 경계선이 끝에 다다르면 종료
        //경계선의 개수 : M-1개, 경계선 : (N-1)/2 , (N-1)/2+M, ...
        int[] borderLines = new int[M-1];
        for(int i=0; i<M-1; i++){ //경계선 세팅
            borderLines[i] = (N-1)/M + (i*M);
        }

        while(true){
            if(borderLines[M-2]>=N-1) break; //마지막 보더라인이 맨 끝에 다다르면

            for(int i=0; i<M-2; i++){
                while(prefixSum[borderLines[i]] < (prefixSum[borderLines[i+1]]-prefixSum[borderLines[i]]) && borderLines[i]<borderLines[i+1]){

                    borderLines[i] = borderLines[i]+1; //경계선 뒤로

                    //그룹간 합 비교해서 answer 갱신
                    for(int j=0; j<M-1; j++){ //0,1
                        if(j == 0) answer =(int) Math.max(answer,prefixSum[borderLines[j]]);
                        else answer = (int) Math.max(answer, prefixSum[borderLines[j]]-prefixSum[borderLines[j-1]]);
                    }
                    answer = (int) Math.max(answer,prefixSum[N] - prefixSum[borderLines[M-2]]); //마지막 보더라인
                }
            }
        }
        System.out.println(answer);

    }
    static void prefixSum(){
        for(int i=1; i<=N; i++){
            prefixSum[i] = prefixSum[i-1] + classes[i-1];
        }
    }

}
