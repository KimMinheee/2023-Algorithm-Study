package minhee.그리디.그리디알고리즘;

import java.io.*;
import java.util.*;

public class Boj1744_수묶기 {
    static int N;
    static List<Integer> negativeData = new ArrayList<>(); //0도 포함
    static List<Integer> positiveData = new ArrayList<>();
    static int answer = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num <= 0) negativeData.add(num);
            else positiveData.add(num);
        }
        //음수(0포함)는 오름차순, 정수는 내림차순으로 정렬
        positiveData.sort(Collections.reverseOrder());
        Collections.sort(negativeData);
        calculate();

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
    static void calculate(){
        //음수 계산
        for(int i=0; i<negativeData.size(); i=i+2){
            if(i == negativeData.size()-1) answer += negativeData.get(i);
            else answer += negativeData.get(i) * negativeData.get(i+1);
        }

        //양수 계산 (1은 곱하는 것보다 더하는 것이 더 크다)
        for(int i=0; i<positiveData.size(); i=i+2){
            if(i == positiveData.size()-1) answer += positiveData.get(i);
            else if(positiveData.get(i)==1 || positiveData.get(i+1)==1) answer += (positiveData.get(i) + positiveData.get(i+1));
            else answer += positiveData.get(i) * positiveData.get(i+1);
        }
    }
}
