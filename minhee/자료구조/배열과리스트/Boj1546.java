package minhee.자료구조.배열과리스트;

import java.io.*;
import java.util.*;

/**
 * BOJ 1546 - 평균
 */
public class Boj1546 {
    static int N;
    static double[] data;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        data = new double[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        double maxValue = Arrays.stream(data).max().getAsDouble();

        for(int i=0; i<N; i++){
            String tmp = String.format("%.2f", data[i] / maxValue * 100) ;
            data[i] = Double.parseDouble(tmp);

        }

        System.out.println(Arrays.stream(data).sum()/N);
        br.close();
    }
}
