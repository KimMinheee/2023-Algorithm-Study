package minhee.정렬.퀵정렬;
import java.io.*;
import java.util.*;
public class Boj11004_K번째수 {
    static int N,K;
    static int[] data;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        data = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        //일반 정렬
        Arrays.sort(data);

        System.out.println(data[K-1]);
    }

}
