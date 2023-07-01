package ch08_6_플로이드워셜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11403_경로찾기 {

    // 자료구조 선언하기(그래프 정보 저장, 최단거리 저장)
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N; // 도시수(노드), 버스 노선의 개수(엣지)
    static int distance[][];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine()); // 도시 수(노드)
        distance = new int[N][N];
        for (int i = 0; i < N; i++) {  // 입력되는 인접 행렬 데이터를 distance 행렬에 그대로 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int v = Integer.parseInt(st.nextToken());
                distance[i][j] = v;
            }
        }
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (distance[i][k] == 1 && distance[k][j] == 1) {
                        distance[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }
}