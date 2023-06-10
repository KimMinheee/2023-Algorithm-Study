package ch08_3_위상정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_2252_줄세우기 {

    // 백준온라인저지 2252번 줄 세우기 Java풀이
    public static void main(String[] args) throws IOException {

        // 입출력에 사용할 객체
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 주어진 정보 받기
        String[] info = br.readLine().split(" ");

        // 학생의 수
        int N = Integer.parseInt(info[0]);
        // 학생의 키 비교한 횟수
        int M = Integer.parseInt(info[1]);

        // 위상정렬에 사용할 진입차수 저장 배열
        int[] edgeCount =new int[N + 1];
        // 위상정렬에 사용할 그래프 2차원 리스트로 구현
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= N+1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 2차원 리스트의 인덱스가 학생번호
        // 주어진 키 비교정보에 따라 2차원 리스트 정보 초기화
        // 리스트 초기화 하면서 진입차수배열 값 초기화
        for (int i = 0; i < M; i++) {
            String[] temp = br.readLine().split(" ");
            graph.get(Integer.parseInt(temp[0])).add(Integer.parseInt(temp[1]));
            edgeCount[Integer.parseInt(temp[1])]++;
        }

        // 위상정렬에 사용할 큐
        Queue<Integer> q = new LinkedList<>();

        // 진입차수가 0인 값 큐에 넣기
        for (int i = 1; i < edgeCount.length; i++) {
            if (edgeCount[i] == 0) {
                q.offer(i);
            }
        }

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            // 큐에서 학생번호 꺼내기
            int studentNo = q.poll();

            // 꺼낸 학생번호 출력값에 저장
            bw.write(String.valueOf(studentNo) + " ");

            // 꺼낸 학생번호의 키 비교한 정보 가져오기
            List<Integer> list = graph.get(studentNo);

            // 키를 비교한 정보의 개수 만큼 반복문 실행
            for (int i = 0; i < list.size(); i++) {
                // 해당 학생보다 뒤에 서야하는 학생의 정보 가져오기
                int temp = list.get(i);
                // 뒤에 서야하는 학생의 진입차수 감소
                edgeCount[temp] -- ;
                // 감소한 진입차수가 0이면 큐에 학생번호 넣기
                if (edgeCount[temp] == 0) {
                    q.offer(temp);
                }
            }
        }

        // 출력
        bw.flush();
    }
}