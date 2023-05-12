package ch05_1_탐색;

import java.util.Scanner;

public class BOJ_11724_연결요소의개수구하기 {

    static int N; // 정점의 개수
    static int M; // 간선의 개수
    static int[][] adj; // 인접행렬

    static boolean[] visit; // 방문 체크

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 정점의 개수
        M = sc.nextInt(); // 간선의 개수

        adj = new int[N + 1][N + 1];

        //인접행렬 입력
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a][b] = 1;
            adj[b][a] = 1;
        }

        visit = new boolean[N + 1];

        int count = 0; // 연결요소 개수

        //방문 배열 돌면서 방문하지 않은 정점이 있으면 탐색하고 연결요소 개수 1 증가
        for (int i = 1; i < N + 1; i++) {
            if (!visit[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    public static void dfs(int start) {
        //방문했다.
        visit[start] = true;

        //방문 배열 처음부터 들면서 간선이 연결되어 있고, 방문을 하지 않았으면 dfs 탐색 ㄱㄱ
        for (int i = 1; i <= N; i++) {
            if (adj[start][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }
}