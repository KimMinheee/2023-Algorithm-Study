package minhee.정수론.소수구하기;

import java.io.*;
import java.util.StringTokenizer;

public class Boj1016_제곱ㄴㄴ수 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken()); //1 ≤ min ≤ 1,000,000,000,000
        long max = Long.parseLong(st.nextToken());

        int size = (int)(max - min +1); //개수
        boolean[] check = new boolean[size]; //true이면 제곱수

        //제곱ㄴㄴ수가 아닌 수 체크
        for(long i=2; i*i <= max; i++){
            long square = i * i; //제곱수
            long idx = min / square;
            if(min % square != 0){
                idx++;
            }

            //제곱수의 배수를 탐색
            for(long j = idx; square * j<=max; j++){ //제곱의 배수가 max보다 작거나 같은 동안
                check[(int)((j*square)-min)] = true;
            }
        }

        int count = 0;
        for(int i=0; i<size; i++){
            if(!check[i]) count++;
        }
        System.out.println(count);
        br.close();
    }
}
