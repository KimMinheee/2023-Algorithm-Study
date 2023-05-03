package week1;

import java.io.*;

public class BOJ_2018_연속된자연수의합구하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); //입력된 자연수 N
        
        int startN = 1;//시작 수
        int endN = 2; //끝 수
        int cnt = 1; //합의 가짓수, 이미 자기 자신을 경우의 수로 가지므로 1
        int sum = startN+endN; //수의 합, 시작점 + 끝점

        //연속되는 수의 합 탐색
        while(startN < N-1){
            // 수의 합이 아직 모자른 경우
            if(sum<N){
                sum += ++endN; //끝점 +1 후 더해주기
            }
            //수의 합이 N인 경우
            else if(sum == N){
                cnt++; //카운트
                sum -= startN++; //현재 시작점 값 합에서 빼주고 시작점 +1
                sum += ++endN; //끝점+1 후 더해주기, 업데이트 된 시작점과 원래 끝점까지 합은 N을 넘지 않음이 보장됨
            }
            //수의 합이 N을 넘어서는 경우, N보다 작거나 같아질 때까지 시작점 업데이트 해야 함
            else{
                sum -= startN++; //현재 시작점 값 합에서 빼주고 시작점 +1
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();

    }
}
