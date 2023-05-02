package week2;

import java.io.*;

public class BOJ_2750_수정렬하기 {
    private static int[] num;
    public static void main (String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        num = new int[N];
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        int partition = N;
        while(partition>1){
            for(int i=0; i<partition-1; i++){
                if(num[i]>num[i+1]){
                    swap(i, i+1);
                }
            }
            partition--;
        }

        for(int i=0; i<N; i++)
            bw.write(num[i] + "\n");
        bw.flush();
        bw.close();
    }
    private static void swap(int idx1, int idx2){
        int tmp = num[idx1];
        num[idx1] = num[idx2];
        num[idx2] = tmp;
    }
}