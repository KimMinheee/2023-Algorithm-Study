package minhee.그리디.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11047_동전0 {
    static int N, K; //동전의 종류, 만들어야 하는 금액
    static int[] coins;
    static int answer = 0; //필요한 동전 개수의 최솟값
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coins = new int[N];

        for(int i=N-1; i>=0; i--){
            coins[i] = Integer.parseInt(br.readLine());
        }

        //높은 숫자 부터 탐색, 만약 동전의 단위가 K보다 크다면 continue
        for(int i=0; i<N; i++){
            if(coins[i] > K) continue;

            answer += K / coins[i];
            K = K%coins[i];

            if(K == 0) break;
        }

        System.out.println(answer);
    }
}
