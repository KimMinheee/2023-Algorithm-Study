package ch08_6_플로이드워셜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11404_가장빠른버스노선 {

    // 자료구조 선언하기(그래프 정보 저장, 최단거리 저장)
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M; // 도시수(노드), 버스 노선의 개수(엣지)
    static int distance[][];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine()); // 도시 수(노드)
        M = Integer.parseInt(br.readLine()); // 버스 노선의 개수(엣지)
        distance = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) { // i 도시 수만큼 반복
            for (int j = 1; j <= N; j++) { // j 도시 수만큼 반복
                if (i == j) {
                    distance[i][j] = 0; //시작 도시와 도착 도시가 같으면 0
                } else {
                    distance[i][j] = 100000001; // 무한대 값 대신 큰수 넣기
                }
            }
        }
        for (int i = 0; i < M; i++) {
            //버스 정보 입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            if (distance[start][end] > time) { // 무한대랑 value 비교
                distance[start][end] = time; // 노선 데이터 distance 행렬에 저장
            }
        }

        //플로이드 워셜 수행
        for (int k = 1; k <= N; k++) { // k(경유지)
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) { // 시작점-끝점 거리가 경유지를 거치는 것보다 크면
                        distance[i][j] = distance[i][k] + distance[k][j]; // 경유지 거치는 경로가 더 짧다는 뜻이기 때문에 update
                    }
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (distance[i][j] == 100000001) { // 한번도 안거친 배열
                    System.out.println("0 ");
                } else {
                    System.out.println(distance[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}