package minhee.탐색.이진탐색;
/**
 * BOJ2343 - 기타 레슨(블루레이)
 */

import java.util.*;
import java.io.*;

public class Boj2343_기타레슨 {
    static int N,M;
    static int[] data;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[N];

        int total = 0;
        int min = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(st.nextToken());
            total += data[i];
            min = Math.max(min, data[i]); //강의의 길이가 가장 큰 것.
        }

        //이진탐색
        System.out.println(binarySearch(min, total));
        br.close();

    }
    static int binarySearch(int low, int high){

        while(low <= high){
            int mid = (low + high) / 2;
            int count = 0;
            int sum = 0;

            for(int i=0; i<N; i++){
                if(sum + data[i] > mid){
                    count ++; // 묶음 한 개 추가
                    sum = 0; //이 i값의 뒤는 묶을 수 없음
                }
                sum += data[i];
            }

            //마지막 값에 잔류하는 게 있다면 cnt +1 추가
            if(sum != 0) count += 1;

            if(count <= M) high = mid -1;
            else low = mid + 1;
        }
        return low;
    }
}