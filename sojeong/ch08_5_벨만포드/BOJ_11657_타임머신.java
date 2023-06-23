package ch08_5_벨만포드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11657_타임머신 {

    // 자료구조 선언하기(그래프 정보 저장, 최단거리 저장)
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M; // 도시수(노드), 버스 노선의 개수(엣지)
    static long distance[];
    static Edge edges[]; // 엣지 리스트 배열

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시 수(노드)
        M = Integer.parseInt(st.nextToken()); // 버스 노선의 개수(엣지)
        edges = new Edge[M + 1];
        distance = new long[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE); // 최단거리 배열 초기화
        for (int i = 0; i < M; i++) { // 엣지 데이터 저장
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, time);
        }

        // 벨만포드 알고리즘
        distance[1] = 0; // 거리 배열에 출발 노드 0으로 초기화
        for (int i = 0; i < N; i++) { // N보다 1개 적은 수만큼 반복
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                // 더 작은 최단 거리가 있을 때 업데이트
                if (distance[edge.start] != Integer.MAX_VALUE
                    && distance[edge.end] > distance[edge.start] + edge.time) {
                    distance[edge.end] = distance[edge.start] + edge.time;
                }
            }
        }
        boolean mCycle = false;
        for (int i = 0; i < M; i++) { // 음수 사이클 확인
            Edge edge = edges[i];
            if (distance[edge.start] != Integer.MAX_VALUE
                && distance[edge.end] > distance[edge.start] + edge.time) {
                mCycle = true; // 업데이트가 가능하다 -> 음수 사이클이 존재한다 mCycle=true로 업데이트
            }
        }
        if (!mCycle) { // 음수 사이클이 존재하지 않을 때
            for (int i = 2; i <= N; i++) {
                if (distance[i] == Integer.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(distance[i]);
                }
            }
        } else {
            System.out.println("-1");
        }
    }
}

class Edge { // 엣지 리스트 다루는 클래스

    int start, end, time; // 시작점, 도착점, 걸리는 시간

    public Edge(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }
}
