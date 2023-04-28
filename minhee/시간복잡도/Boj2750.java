package minhee.시간복잡도;
import java.io.*;
import java.util.*;

/**
 * BOJ 2750 - 수 정렬하기
 */

public class Boj2750 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        List<Integer> data = new ArrayList<>();

        for(int i=0; i<N; i++){
            data.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(data);
        StringBuilder sb = new StringBuilder();

        for(Integer i : data){
            sb.append(i+"\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
