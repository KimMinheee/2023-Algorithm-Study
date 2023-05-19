package minhee.자료구조.투포인터;

import java.io.*;
import java.util.*;

/**
 * BOJ1253 - 좋다('좋은 수' 구하기)
 * 주의)
 * - N개의 수 중 음수 가능!
 */
public class Boj1253_좋다 {
    static int N;
    static int[] data;
    static int answer = 0;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        //정렬
        Arrays.sort(data);

        System.out.println(getAnswer());
        br.close();
    }
    static int getAnswer(){
        int answer = 0;

        for(int i=0; i<N; i++){
            int target = data[i];
            int front = 0;
            int back = N-1;

            while(front < back){
                if(front == i) front++;
                else if(back == i) back--;
                else{
                    int num = data[front] + data[back];
                    if(num > target) back--;
                    else if(num < target) front++;
                    else{
                        //좋은 수 인 경우
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
