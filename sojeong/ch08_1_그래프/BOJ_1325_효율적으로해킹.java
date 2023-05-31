package ch08_1_그래프;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1325_효율적으로해킹 {

    static ArrayList<Integer>[] arr; // 그래프 데이터 저장 인접 리스트
    static boolean visited[]; // 방문 유무 저장 배열
    static int N, M; // 노드, 엣지 개수
    static int ans[]; // 정답 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 컴퓨터 개수 (노드)
        M = Integer.parseInt(st.nextToken()); // 신뢰 관계 개수 (엣지)
        arr = new ArrayList[N + 1];
        ans = new int[N + 1];
        for (int i = 0; i <= N; i++) { // arr인접 리스트 ArrayList에 초기화
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) { // 신뢰 관계 개수만큼 반복하면서 입력받기
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[A].add(B);
        }
        for (int i = 1; i <= N; i++) { // 모든 노드로 bfs실행
            visited = new boolean[N + 1];
            BFS(i);
        }
        int max = 0;
        for (int i = 1; i <= N; i++) { // max값 찾기
            if (ans[i] > max) {
                max = ans[i];
            }
        }
        for (int i = 1; i <= N; i++) { // max값과 같은 값을 지닌 인덱스 찾아서 출력
            if (ans[i] == max) {
                System.out.print(i + " ");
            }
        }
    }

    private static void BFS(int Node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(Node);
        visited[Node] = true;
        while (!queue.isEmpty()) {
            int now_Node = queue.poll();
            for (int i : arr[now_Node]) {
                if (visited[i] == false) {
                    visited[i] = true;
                    ans[i]++; // 신규 노드 인덱스의 정답 배열 값 증가
                    queue.add(i);
                }
            }
        }
    }
}