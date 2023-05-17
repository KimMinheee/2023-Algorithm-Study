package week1;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10986_나머지합구하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //숫자 수
        int M = Integer.parseInt(st.nextToken()); //나누어떨어지는 수


        long[] ps = new long[N+1]; //구간합 담는 배열
        long cnt = 0; //나누어떨어지는 개수
        long[] remain = new long[M]; //누적합을 M으로 나눈 나머지에 대한 수를 저장하는 배열
        
        //구간 합
        st = new StringTokenizer(br.readLine()); //숫자 받기
        for(int i=1; i<=N; i++){
            ps[i] = (ps[i-1] + Integer.parseInt(st.nextToken())) % M; //누적합을 M으로 나누기
            if(ps[i] == 0) //누적합이 M으로 나누어지는 경우 카운트
                cnt++;
            remain[(int)ps[i]]++; //나머지 개수 업데이트
        }

        //ps[j]%M == ps[i-1]%M인 경우 + 하나의 요소가 나누어 떨어지는 경우
        for(int i=0; i<M; i++){
            if(remain[i] > 1)
                cnt += (remain[i]*(remain[i]-1)/2); //조합
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}
