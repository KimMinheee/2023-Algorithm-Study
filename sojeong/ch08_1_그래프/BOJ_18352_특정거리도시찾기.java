package ch08_1_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18352_특정거리도시찾기 {

    static ArrayList<Integer>[] arr;
    static int visited[];
    static int N, M, K, X;
    static List<Integer> ans;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시 개수(노드)
        M = Integer.parseInt(st.nextToken()); // 도로 개수
        K = Integer.parseInt(st.nextToken()); // 거리 정보
        X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호
        arr = new ArrayList[N + 1];
        ans = new ArrayList<Integer>();

        for (int i = 0; i <= N; i++) { // 연결리스트에 노드 추가
            arr[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) { //단방향 도시 정보 입력받기(간선 정보 입력)
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // A번 도시
            int B = Integer.parseInt(st.nextToken()); // B번 도시
            if (A <= 0 || B > N) {
                System.out.println("A는 1이상의 자연수이고, B는 N이하의 자연수입니다.");
            } else {
                arr[A].add(B);
            }
        }
        visited = new int[N + 1]; // 방문 배열 초기화
        for (
            int i = 0; i <= N; i++) {
            visited[i] = -1;
        }

        BFS(X);
        for (int i = 0; i <= N; i++) {
            if (visited[i] == K) { // K: 거리정보
                ans.add(i);
            }
        }
        if (ans.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(ans);
        }
        for (int temp : ans) {
            System.out.println(temp);
        }

    }

    private static void BFS(int Node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(Node);
        visited[Node]++;
        while (!queue.isEmpty()) {
            int now_Node = queue.poll();
            for (int i : arr[now_Node]) {
                if (visited[i] == -1) { // 방문한 적이 없으면 방문하고 업데이트
                    visited[i] = visited[now_Node] + 1;
                    queue.add(i);
                }
            }
        }
    }
}