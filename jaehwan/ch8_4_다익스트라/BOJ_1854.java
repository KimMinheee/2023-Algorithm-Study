import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Node_1854 implements Comparable<Node_1854> {
    int v, weight;

    public Node_1854(int v, int weight){
        this.v = v;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node_1854 o) {
        return weight - o.weight;
    }
}
public class BOJ_1854 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M, K;
    private static List<Node_1854>[] edge;
    private static PriorityQueue<Integer>[] dist;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        init();

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edge[u].add(new Node_1854(v, weight));
        }

        dijkstra(1);
        print();

        br.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node_1854> pq = new PriorityQueue<>();
        pq.add(new Node_1854(start, 0));
        dist[start].add(0);

        while (!pq.isEmpty()) {
            Node_1854 cur = pq.poll();

            for (Node_1854 next : edge[cur.v]) {
                if (dist[next.v].size() < K) { // 저장된 최단비용의 수가 K개 이하
                    dist[next.v].add((cur.weight + next.weight) * -1);
                    pq.add(new Node_1854(next.v, cur.weight + next.weight));
                } else if ((dist[next.v].peek() * -1) > cur.weight + next.weight) {
                    dist[next.v].poll();
                    dist[next.v].add((cur.weight + next.weight) * -1);
                    pq.add(new Node_1854(next.v, cur.weight + next.weight));
                }
            }
        }
    }

    private static void print() {
        for (int i = 1; i <= N; ++i){
            if (dist[i].size() == K) System.out.println(dist[i].peek() * -1);
            else System.out.println(-1);
        }
    }

    private static void init() {
        dist = new PriorityQueue[N + 1];
        edge = new ArrayList[N + 1];
        for (int i = 0 ; i < N + 1; ++i) {
            dist[i] = new PriorityQueue<>(K);
            edge[i] = new ArrayList<>();
        }
    }
}

//우선순위 큐를 사용한 1차원배열을 사용후 우선순위 큐의 용량을 k개로 할당한 후, 내림차순으로 정렬하면 가장 앞의 원소가 k번째 비용이된다.
