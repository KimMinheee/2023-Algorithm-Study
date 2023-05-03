package week2;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_ATM_11399 {

    private static int[] num;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        //삽입정렬 시작
        for(int i=1; i<N; i++){
            int pick = num[i];
            int j=i-1;
            for(; j>=0 && num[j]>pick; j--){ //앞으로 이동하면서 pick한 수보다 큰 수들을 shift
                num[j+1] = num[j];
            }
            num[j+1] = pick; //for문 마지막에 j--되므로 +1해줌
        }

        int sum = 0; //합
        for(int i=N-1; i>=0; i--){
            for(int j=0; j<=i; j++){
                sum += num[j];
            }
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
