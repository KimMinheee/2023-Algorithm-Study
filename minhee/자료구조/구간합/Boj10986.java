package minhee.자료구조.구간합;

/**
 * BOJ10986 - 나머지 합
 *
 * 시간 초과 나는 솔루션)
 * - 누적합 배열이 있을 때, 한 누적합을 기준으로 그 이전 위치의 누적합의 값을 이용해 M의 배수가 되는 개수 찾음 -> O(n^2)
 *
 * 교재 솔루션)
 * 1. 누적합 배열 생성
 * 2. 누적합 배열의 모든 값을 M으로 나머지 연산을 수행해 값 업데이트
 * 3. 변경된 누적합 배열에서 원소 값이 0인 개수만 세서 정답에 더함.(이미 M으로 나누어진다는 뜻)
 * 4. 누적합 배열에서 (M으로 나머지 연산한)원소의 값이 같은 2개의 원소를 뽑는 모든 경우의 수를 구하여 정답에 더한다.
 */

import java.util.*;
import java.io.*;

public class Boj10986 {
    static int N,M;//수열의 개수, 나누어떨어져야 하는 수
    static int[] prefixSum;//합 배열
    static int[] count; //나머지 저장하는 배열


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        prefixSum = new int[N];
        count = new int[M]; //0,1,2,...,M-1

        st = new StringTokenizer(br.readLine());
        prefixSum[0] = Integer.parseInt(st.nextToken());
        for(int i=1; i<N; i++) { //누적합 배열
            prefixSum[i] = prefixSum[i-1] + Integer.parseInt(st.nextToken());
        }


        int answer = 0;

        //count 구하기
        for(int i=0; i<N; i++) {
           int remain = prefixSum[i] % M;
           if(remain == 0) answer++;
           count[remain] = count[remain]+1;
        }

        /**
         * s[j]%M == s[i-1]%M
         * = (s[j] - s[i-1])%M = 0
         *
         * count 배열 순회하며 나머지가 같은 인덱스 중 2개를 뽑음
         */
        for(int i=0; i<M; i++){
            if(count[i]>1){
                answer = answer + (count[i] * (count[i]-1) / 2);
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();

    }
}