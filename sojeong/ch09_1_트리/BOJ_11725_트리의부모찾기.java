package ch09_1_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725_트리의부모찾기 {

    static int N; // 입력 받을 노드 개수
    static boolean[] visited; // 방문 기록 배열
    static ArrayList<Integer> tree[]; // 트리 데이터 저장 인접 리스트
    static int answer[]; // 부모노드 저장 배열(출력할 데이터)
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        tree = new ArrayList[N + 1];
        answer = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            tree[i] = new ArrayList<>(); // tree 인접 리스트 ArrayList 초기화
        }
        for (int i = 0; i < N - 1; i++) {  // tree인접 리스트에 트리 데이터 저장(노드 데이터 저장)
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        dfs(1); // 트리 루트 1부터 dfs시작
        for (int i = 2; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    // dfs 탐색하면서 부모 노드를 정답 배열에 저장
    private static void dfs(int index) {
        visited[index] = true;
        for (int i : tree[index]) {
            if (!visited[i]) {
                answer[i] = index;
                dfs(i);
            }
        }
    }
}