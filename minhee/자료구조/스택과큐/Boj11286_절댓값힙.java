package minhee.자료구조.스택과큐;

import java.io.*;
import java.util.*;
public class Boj11286_절댓값힙 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Number> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());

            if(x!=0) pq.add(new Number(Math.abs(x),x));
            else{
                if(!pq.isEmpty()){
                    Number num = pq.poll();
                    sb.append(num.value+"\n");
                }
                else sb.append(0+"\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
class Number implements Comparable<Number>{
    int absolute; //절댓값
    int value; //실제 값

    public Number(int absolute, int value){
        this.absolute = absolute;
        this.value = value;
    }

    @Override
    public int compareTo(Number n2){
        int absoluteDiff = this.absolute - n2.absolute;
        if(absoluteDiff == 0){
            return this.value - n2.value;
        }
        return absoluteDiff;
    }
}
