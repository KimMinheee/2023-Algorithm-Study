package ch08_3_위상정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252_줄세우기 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학생수(노드)
        int M = Integer.parseInt(st.nextToken()); // 비교 횟수(엣지)

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>(); // 데이터 저장 인접 리스트
        for(int i = 0; i <= N; i++){ // 학생 수만큼 인접 리스트 초기화
            arr.add(new ArrayList<>());
        }

        int[] indegree = new int[N + 1]; // 진입차수 저장 배열
        for(int i = 0; i < M; i++) { // 입력받은 비교 횟수만큼 반복문 돌면서 진입차수 배열 초기화
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            arr.get(S).add(E);
            indegree[E]++;
        }

        // 위상정렬에 사용할 큐
        Queue<Integer> q = new LinkedList<>();

        // 진입차수가 0인 값 큐에 넣기
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) { // 진입 차수 배열의 값이 0인 학생(노드) 큐에 삽입
                q.offer(i);
            }
        }

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            int studentNo = q.poll();// 큐에서 학생번호 꺼내기
            bw.write(String.valueOf(studentNo) + " "); // 꺼낸 학생번호 출력값에 저장
            for (int i:arr.get(studentNo)) {
                indegree[i] -- ;
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }
        }
        bw.flush();
        bw.close();
    }
}