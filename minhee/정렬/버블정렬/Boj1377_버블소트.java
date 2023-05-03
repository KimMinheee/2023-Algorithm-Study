package minhee.정렬.버블정렬;

import java.io.*;
import java.util.*;

/**
 * Boj1377_버블소트
 * - 힌트 보고 품
 */

public class Boj1377_버블소트 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Data[] data = new Data[N]; //N+1개(1~N)
        for(int i=0;  i<N; i++){
            int value = Integer.parseInt(br.readLine());
            data[i] = new Data(i,value);
        }

        Arrays.sort(data);

        int answer = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            if(data[i].index-i > answer){
                answer = data[i].index-i;
            }
        }
        System.out.println(answer+1);
    }
}
class Data implements Comparable<Data>{
    int index;
    int value;

    public Data(int index, int value){
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Data d2){
        int tmp = this.value - d2.value;
        if(tmp == 0) return this.index - d2.index;
        return this.value-d2.value;
    }
}
