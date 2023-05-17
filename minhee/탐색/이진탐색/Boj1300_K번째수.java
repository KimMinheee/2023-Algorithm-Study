package minhee.탐색.이진탐색;

import java.io.*;

public class Boj1300_K번째수 {
    static int n;
    static int k;
    static int answer = 0;
    static int[][] map;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        int L = 1;
        int R = k; //K 보다 큰 인덱스는 볼 필요 x : 작거나 같은 것들의 개수와 관련
        while(L <= R){
            int mid = (L + R)/2;
            int count = 0;

            for(int i=1; i<=n; i++){
                count += Math.min(mid/i,n); //최대 n까지만 가능
            }

            if(count < k){
                L = mid+1;
            }
            else{ //count >= k -> 일단 포함되므로 answer에 값은 넣어놓고 범위를 낮춘다.
                R = mid - 1;
                answer = mid;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
