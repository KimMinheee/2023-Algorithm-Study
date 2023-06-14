package ch08_3_위상정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1516_게임개발 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 건물 종류 수
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>(); // 데이터 저장 인접 리스트
        for (int i = 0; i <= N; i++) { // 건물 개수만큼 인접 리스트 초기화
            arr.add(new ArrayList<>());
        }

        int[] indegree = new int[N + 1]; // 진입차수 저장 배열
        int[] self = new int[N + 1]; // 자기 자신을 짓는데 걸리는 시간
        for (int j = 1; j <= N; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            self[j] = Integer.parseInt(st.nextToken()); // 건물 짓는데 걸리는 시간
            while (true) { // 인접 리스트 초기화
                int temp = Integer.parseInt(st.nextToken());
                if (temp == -1)
                    break;
                arr.get(temp).add(j);
                indegree[j]++; // 진입차수 배열 초기화
            }
        }

        Queue<Integer> q = new LinkedList<>();  // 위상정렬에 사용할 큐
        for (int k = 1; k <= N; k++) { //건물 개수만큼
            if (indegree[k] == 0) { //진입차수 배열의 값이 0인 건물(노드)를 큐에 삽입
                q.offer(k);
            }
        }
        int[] result = new int[N + 1];
        while (!q.isEmpty()) {
            int now = q.poll(); // 현재노드 = 큐에서 데이터 poll
            for (int next : arr.get(now)) { // 현재 노드에서 갈 수 있는 노드의 개수
                indegree[next]--; // 타깃 노드 진입 차수 배열 --
                result[next] = Math.max(result[next], result[now] + self[now]);
                if (indegree[next] == 0) { // 타겟 노드의 진입 차수가 0일 때
                    q.offer(next); // 우선순위 큐에 타겟 노드 추가
                }
            }
        }
        for (int l = 1; l <= N; l++) {
            System.out.println(result[l] + self[l]);
        }
    }
}