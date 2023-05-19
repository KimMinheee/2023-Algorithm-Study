package minhee.자료구조.투포인터;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Boj1940 - 주몽(주몽의 명령)
 */
public class Boj1940_주몽 {
    static int N,M;
    static int[] data;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        data = new int[N];
        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        //정렬(연속성 부여)
        Arrays.sort(data);

        System.out.println(getAnswer());
    }
    static int getAnswer(){
        int front = 0;
        int back = N-1;
        int answer = 0;

        while(front < back){
            int num = data[front] + data[back];

            if(num > M) back--;
            else if(num < M) front++;
            else{
                front++;
                answer++;
            }
        }
        return answer;
    }
}
