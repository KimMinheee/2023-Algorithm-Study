package ch08_6_플로이드워셜;

import java.io.*;
import java.util.*;

public class BOJ_1389_케빈베이컨 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];

        // 최솟값을 구해야 하므로 최대 관계수로 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = 5001;
                // 나 자신은 항상 0
                if (i == j) {
                    arr[i][j] = 0;
                }
            }
        }

        // 친구 사이는 1로 설정(양방향)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            arr[a][b] = arr[b][a] = 1;
        }

        // 플로이드 와샬 알고리즘
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 최단경로
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int ans = 0;

        // 단계의 합이 제일 작은 사람 찾기
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += arr[i][j];
            }

            if (min > sum) {
                //index가 0부터 시작하므로 +1
                ans = i + 1;
                min = sum;
            }
        }

        System.out.println(ans);

    }
}