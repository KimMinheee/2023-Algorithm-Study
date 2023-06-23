package ch08_4_다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Stream;

/*
 * 다익스트라는 그래프에서 간선에 가중치가 존재할때 사용됨
 * 인접매트릭스, 인접리스트 둘 중하나를 input range에 따라 적절히 사용
 * 입력범위가크므로 리스트를 이용해서 품
 * */
//시작점에 연결된 간선을 저장할 클래스선언
class Edge implements Comparable<Edge> {

    int i, v;

    public Edge(int i, int v) {
        this.i = i;
        this.v = v;
    }

    // 우선순위 큐에서 사용시 최솟값 정렬
    @Override
    public int compareTo(Edge o) {
        return this.v - o.v;
    }
}

public class BOJ_1753_최단경로 {

    // 전역적 접근이 필요한 변수 - 인접리스트 list, 결과거리 dist
    static ArrayList<Edge> list[];
    static int dist[];

    public static void main(String[] args) throws IOException {
        // Scanner보다 BuggeredReader가 빠르고 효율적임
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // input 받기
        int[] in = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int dot = in[0], line = in[1];
        int start = Integer.parseInt(br.readLine());

        // input 받기 - 연결정보 저장
        list = new ArrayList[dot + 1]; // 편의상 0번은 사용하지 않을것이므로 +1
        for (int i = 1; i < list.length; i++) {
            list[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i < line; i++) {
            String[] tt = br.readLine().split(" ");
            int a = Integer.parseInt(tt[0]);    //노드1
            int b = Integer.parseInt(tt[1]);    //노드2
            int w = Integer.parseInt(tt[2]);    // 거리
            list[a].add(new Edge(b, w));
        }

        // start부터 각 dot으로 가는 최단거리를 저장할 결과배열 dist 선언 및 초기화
        dist = new int[dot + 1]; //input 특성상 0번을 사용하지 않으므로 + 1
        Arrays.fill(dist, Integer.MAX_VALUE); // 최솟값을 구해야하므로 MAX값으로 초기화
        dist[start] = 0; // 시작점 거리값

        // 다익스트라로 start에서 연결된 모른 경로값을 탐색
        dijkstra(start);

        // 결과 출력문 (0번 제외)
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    private static void dijkstra(int s) {
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(); //pq를 사용하면 최소값 기준으로 들어가기 때문에 연산이 줄어든다
        pq.add(new Edge(s, 0)); // 탐색 시작점

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            // 탐색할 점에 연결된 정보기반으로 dist 갱신
            for (Edge next : list[now.i]) {
                if (dist[next.i] > now.v + next.v) {
                    dist[next.i] = now.v + next.v;
                    pq.add(new Edge(next.i, dist[next.i]));
                }
            }
        }
    }
}