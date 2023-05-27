package minhee.정수론.유클리드호제법;

import java.io.*;
import java.util.*;

public class Boj1934_최소공배수 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(getLCM(a,b))+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static int getLCM(int a, int b){
        return (a * b) / gcd(a,b);
    }
    static int gcd(int a, int b){
        int small = Math.min(a,b);
        int large = Math.max(a,b);

        if(small == 0) return large;

        int tmp = large % small;
        if(tmp == 0) return small;

        return gcd(small,tmp);
    }
}
