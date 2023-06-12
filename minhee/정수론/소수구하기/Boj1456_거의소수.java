package minhee.정수론.소수구하기;

import java.io.*;
import java.util.*;

public class Boj1456_거의소수 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int[] data = new int[10000001];

        for(int i=0; i<data.length; i++){
            data[i] = i; //0 ~ 10^7
        }

        //에라토스테네스 체
        for(int i=2; i<Math.sqrt(data.length); i++){
            if(data[i] == 0) continue;
            for(int j=i+i; j<data.length; j+=i){
                data[j] = 0;
            }
        }

        int count = 0;
        //거의 소수 찾기
        for(int i=2; i<data.length; i++){
            if(data[i] != 0){
                long tmp = i;
                while((double)i <= (double)B / (double)tmp){
                    if((double)A / (double)tmp <= (double)i){
                        count++;
                    }
                    tmp = tmp * i;
                }
            }
        }

        System.out.println(count);
        br.close();
    }

}
