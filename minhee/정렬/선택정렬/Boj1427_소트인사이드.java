package minhee.정렬.선택정렬;

import java.util.*;
import java.io.*;
public class Boj1427_소트인사이드 {
    static int[] data;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tmp = br.readLine().split("");


        //sol1. Arrays의 sort()메소드
        //Integer[] data = Arrays.stream(tmp).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        //Arrays.sort(data, Collections.reverseOrder());

        //sol2. 선택정렬 사용
        data = Arrays.stream(tmp).mapToInt(Integer::parseInt).toArray();
        selectionSort();

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    static void selectionSort(){
        for(int i=0; i<data.length-1 ;i++){

            int max = data[i];
            int maxIdx = i;

            for(int j=i+1; j<data.length; j++){
                if(data[j] > max){
                    max = data[j];
                    maxIdx = j;
                }
            }

            //바꾸기
            int tmp = data[maxIdx];
            data[maxIdx] = data[i];
            data[i] = tmp;

            sb.append(data[i]);
        }
        sb.append(data[data.length-1]);
    }
}
