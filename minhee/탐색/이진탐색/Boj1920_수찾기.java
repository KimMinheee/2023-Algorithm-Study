package minhee.탐색.이진탐색;

/**
 * BOJ1920 - 수 찾기
 * : 이진탐색 알고리즘 사용
 * - 정렬 필요함
 */

import java.io.*;
import java.util.*;
public class Boj1920_수찾기 {
    static int N,M; //자연수의 개수, 존재하는지 찾아야 하는 수
    static int[] data;
    static int[] findNums;
    static StringBuilder sb = new StringBuilder();
    static boolean isFind = false;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        findNums = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            findNums[i] = Integer.parseInt(st.nextToken());
        }

        //이진 탐색 조건 : 정렬
        Arrays.sort(data);

        //M번 존재하는지 찾기
        for(int i=0; i<M; i++){
            sb.append(find(findNums[i],0,N-1)).append("\n");
            isFind = false;
        }
        System.out.println(sb.toString());
        br.close();
    }

    static int find(int findNum,int leftIdx, int rightIdx){
        int midIdx = (leftIdx + rightIdx) / 2;
        int midValue = data[midIdx];

        if(leftIdx > rightIdx || leftIdx<0 || rightIdx>=N ) return 0; //범위를 넘어가거나 leftIdx,rightIdx가 뒤바뀔경우

        if(findNum == midValue || data[leftIdx]==findNum || data[rightIdx]==findNum) {
            isFind = true;
            return 1;
        }
        else if(findNum < midValue){
            find(findNum, leftIdx, midIdx-1);
        }
        else{
            find(findNum, midIdx+1, rightIdx);
        }

        if(isFind) return 1;
        return 0;
    }
}
